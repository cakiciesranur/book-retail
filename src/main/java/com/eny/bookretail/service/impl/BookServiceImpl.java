package com.eny.bookretail.service.impl;

import com.eny.bookretail.dto.request.BookDto;
import com.eny.bookretail.dto.request.UpdateBookDto;
import com.eny.bookretail.dto.response.BookResponse;
import com.eny.bookretail.exception.runtime.ProductNotFoundException;
import com.eny.bookretail.mapper.BookMapper;
import com.eny.bookretail.model.BookEntity;
import com.eny.bookretail.model.StockEntity;
import com.eny.bookretail.repository.BookRepository;
import com.eny.bookretail.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    @Transactional
    public BookResponse createBook(BookDto dto) {
        BookEntity bookEntity = bookMapper.toEntity(dto);

        StockEntity stock = new StockEntity();
        int quantity = dto.getStock() != null ? dto.getStock().getQuantity() : 0;
        stock.setQuantity(quantity);
        stock.setBook(bookEntity);

        bookEntity.setStock(stock);
        bookRepository.save(bookEntity);

        return bookMapper.toResource(bookEntity);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        List<BookResponse> responseList = new ArrayList<>();
        books.forEach(a -> {
            BookResponse bookResponse = bookMapper.toResource(a);
            responseList.add(bookResponse);

        });
        return responseList;
    }

    @Override
    public BookEntity getBookById(Long id) {
        Optional<BookEntity> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new ProductNotFoundException();
        }
    }

    @Transactional
    @Override
    public boolean updateBook(UpdateBookDto dto) {
        Optional<BookEntity> bookOpt = bookRepository.findById(dto.getBookId());

        if (!bookOpt.isPresent()) {
            throw new ProductNotFoundException();
        }

        BookEntity book = bookOpt.get();
        if (dto.getName() != null) {
            book.setName(dto.getName());
        }
        if (dto.getAuthor() != null) {
            book.setAuthor(dto.getAuthor());
        }

        if (dto.getDescription() != null) {
            book.setDescription(dto.getDescription());
        }

        if (dto.getUnitPrice() != 0.0) {
            book.setUnitPrice(dto.getUnitPrice());
        }

        if (dto.getStock() != null) {
            book.getStock().setQuantity(dto.getStock().getQuantity());
        }

        bookRepository.save(book);
        return true;
    }

    @Override
    public BookResponse getBookDetails(long id) {
        Optional<BookEntity> bookOpt = bookRepository.findById(id);
        if (!bookOpt.isPresent()) {
            throw new ProductNotFoundException();
        }

        BookEntity book = bookOpt.get();
        return bookMapper.toResource(book);
    }
}
