package com.eny.bookretail.service.impl;

import com.eny.bookretail.dto.request.StockDto;
import com.eny.bookretail.dto.response.StockResponse;
import com.eny.bookretail.exception.runtime.StockNotAvailableException;
import com.eny.bookretail.exception.runtime.StockNotFoundException;
import com.eny.bookretail.model.BookEntity;
import com.eny.bookretail.model.StockEntity;
import com.eny.bookretail.repository.StockRepository;
import com.eny.bookretail.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements IStockService {
    @Autowired
    private StockRepository repository;

    @Override
    public StockEntity createStock(StockDto dto) {
        StockEntity stock = new StockEntity();
        stock.setQuantity(dto.getQuantity());
        return repository.save(stock);
    }

    @Override
    public StockEntity getStockInfoByBook(BookEntity book) {
        Optional<StockEntity> stock = repository.findByBookId(book.getId());
        if (stock.isPresent()) {
            return stock.get();
        }
        return new StockEntity();
    }

    @Override
    public boolean isStockAvailable(BookEntity entity, int quantity) {
        Optional<StockEntity> stock = repository.findByBookId(entity.getId());
        return stock.isPresent() ? stock.get().getQuantity() >= quantity : false;
    }

    @Override
    public boolean decreaseStockQuantity(BookEntity book, int amount) {
        Optional<StockEntity> stockOpt = repository.findByBookId(book.getId());
        if (!stockOpt.isPresent()) {
            throw new StockNotFoundException();
        }

        StockEntity stock = stockOpt.get();
        int currentQuantity = stock.getQuantity();
        if (currentQuantity < amount) {
            throw new StockNotAvailableException();
        }
        stock.setQuantity(currentQuantity - amount);
        repository.save(stock);
        return true;

    }

    @Override
    public StockResponse getStockInfoByBookId(long bookId) {
        Optional<StockEntity> stockOpt = repository.findByBookId(bookId);
        if (!stockOpt.isPresent()) {
            throw new StockNotFoundException();
        }
        return new StockResponse(bookId, stockOpt.get().getQuantity());
    }

    @Override
    public StockResponse getStockById(long id) {
        Optional<StockEntity> stockOpt = repository.findById(id);
        if (!stockOpt.isPresent()) {
            throw new StockNotFoundException();
        }
        StockEntity stock = stockOpt.get();
        return new StockResponse(stock.getBook().getId(), stock.getQuantity());
    }

    @Override
    public boolean updateStockById(long id, StockDto dto) {
        Optional<StockEntity> stockOpt = repository.findById(id);
        if (!stockOpt.isPresent()) {
            throw new StockNotFoundException();
        }
        StockEntity stock = stockOpt.get();
        stock.setQuantity(dto.getQuantity());
        repository.save(stock);
        return true;
    }

    @Override
    public boolean updateStockByBookId(long bookId, StockDto dto) {
        Optional<StockEntity> stockOpt = repository.findByBookId(bookId);
        if (!stockOpt.isPresent()) {
            throw new StockNotFoundException();
        }

        StockEntity stock = stockOpt.get();
        stock.setQuantity(dto.getQuantity());
        repository.save(stock);
        return true;

    }
}
