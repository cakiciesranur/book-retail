package com.eny.bookretail.service.impl;

import com.eny.bookretail.dto.request.OrderDto;
import com.eny.bookretail.dto.request.OrderItemDto;
import com.eny.bookretail.dto.request.UpdateOrderDto;
import com.eny.bookretail.dto.response.OrderResponse;
import com.eny.bookretail.enums.OrderStatus;
import com.eny.bookretail.exception.runtime.CancelOrderException;
import com.eny.bookretail.exception.runtime.OrderNotFoundException;
import com.eny.bookretail.exception.runtime.OrderUpdateNotAllowedException;
import com.eny.bookretail.exception.runtime.StockNotAvailableException;
import com.eny.bookretail.mapper.OrderMapper;
import com.eny.bookretail.model.BookEntity;
import com.eny.bookretail.model.CustomerEntity;
import com.eny.bookretail.model.OrderDetailEntity;
import com.eny.bookretail.model.OrderEntity;
import com.eny.bookretail.repository.OrderRepository;
import com.eny.bookretail.service.IBookService;
import com.eny.bookretail.service.ICustomerService;
import com.eny.bookretail.service.IOrderService;
import com.eny.bookretail.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IStockService stockService;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    @Override
    public boolean createOrder(OrderDto dto) {
        CustomerEntity customer = customerService.getCustomerById(Long.valueOf(dto.getCustomerId()));

        OrderEntity newOrder = new OrderEntity();
        newOrder.setCustomer(customer);
        newOrder.setStatus(OrderStatus.ORDERED);

        dto.getOrderItems().forEach(item -> {
            BookEntity book = bookService.getBookById(Long.valueOf(item.getBookId()));
            int wantedQuantity = item.getQuantity();
            if (!stockService.isStockAvailable(book, wantedQuantity)
                    || !stockService.decreaseStockQuantity(book, wantedQuantity)
            ) {
                throw new StockNotAvailableException();
            }
            OrderDetailEntity details = createOrderDetail(dto, item, book, newOrder);
            newOrder.getOrderDetails().add(details);

            orderRepository.save(newOrder);

        });

        return true;
    }

    @Override
    public OrderResponse getOrderById(long id) {
        Optional<OrderEntity> orderOpt = orderRepository.findById(id);
        if (orderOpt.isPresent()) {
            return orderMapper.toResource(orderOpt.get());
        }
        throw new OrderNotFoundException();
    }

    @Override
    public boolean updateOrder(long id, UpdateOrderDto dto) {
        Optional<OrderEntity> orderOpt = orderRepository.findById(id);
        if (orderOpt.isEmpty()) {
            throw new OrderNotFoundException();
        }

        OrderEntity order = orderOpt.get();
        if (!OrderStatus.ORDERED.equals(order.getStatus())) {
            throw new OrderUpdateNotAllowedException();
        }

        order.setStatus(dto.getNewOrderStatus());
        if (OrderStatus.CANCELED.equals(dto.getNewOrderStatus())) {
            order.getOrderDetails().forEach(orderDetail -> {
                Long bookId = orderDetail.getBook().getId();
                if (!stockService.increaseStockByBookId(bookId, orderDetail.getQuantity())) {
                    throw new CancelOrderException();
                }
            });

        }
        orderRepository.save(order);

        return true;
    }

    @Override
    public List<OrderResponse> getCustomerOrders(long customerId) {
        CustomerEntity customer = customerService.getCustomerById(customerId);

        if (customer.getAddress() == null || customer.getOrders().isEmpty()) {
            return Collections.emptyList();
        }

        return customer.getOrders().stream().map(a -> orderMapper.toResource(a)).collect(Collectors.toList());
    }

    private OrderDetailEntity createOrderDetail(OrderDto dto, OrderItemDto item, BookEntity book, OrderEntity newOrder) {
        OrderDetailEntity details = new OrderDetailEntity();
        details.setBook(book);
        details.setQuantity(item.getQuantity());
        details.setOrder(newOrder);
        details.setPrice(item.getPrice());
        details.setTotalPrice(dto.getTotalPrice());
        return details;
    }
}
