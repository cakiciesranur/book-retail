package com.eny.bookretail.service;

import com.eny.bookretail.dto.request.BookDto;
import com.eny.bookretail.dto.request.UpdateBookDto;
import com.eny.bookretail.dto.response.BookResponse;
import com.eny.bookretail.model.BookEntity;

import java.util.List;

public interface IBookService {
    BookResponse createBook(BookDto dto);

    List<BookResponse> getAllBooks();

    BookEntity getBookById(Long id);

    boolean updateBook(UpdateBookDto dto);

    BookResponse getBookDetails(long id);
}
