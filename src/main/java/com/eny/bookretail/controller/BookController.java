package com.eny.bookretail.controller;

import com.eny.bookretail.dto.request.BookDto;
import com.eny.bookretail.dto.request.UpdateBookDto;
import com.eny.bookretail.dto.response.BookResponse;
import com.eny.bookretail.dto.response.GenericResponse;
import com.eny.bookretail.service.GenericResponseService;
import com.eny.bookretail.service.IBookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private GenericResponseService genericResponseService;

    @PostMapping("/")
    @ApiOperation(value = "This creates a new book")
    public GenericResponse createBook(@Valid @RequestBody BookDto dto) {
        BookResponse bookResponse = bookService.createBook(dto);
        return genericResponseService.createResponseNoError("Created book successfully!", bookResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This gets information of book")
    public GenericResponse getBook(@PathVariable("id") long id) {
        BookResponse bookResponse = bookService.getBookDetails(id);
        return genericResponseService.createResponseNoError(" ", bookResponse);
    }

    @GetMapping("/all")
    @ApiOperation(value = "This gets all books")
    public GenericResponse getAllBooks() {
        List<BookResponse> books = bookService.getAllBooks();
        return genericResponseService.createResponseNoError("", books);
    }


    @PostMapping("/updateBook")
    @ApiOperation(value = "This updated the book")
    public GenericResponse updateBook(@Valid @RequestBody UpdateBookDto dto) {
        boolean isUpdated = bookService.updateBook(dto);
        return genericResponseService.createResponseNoError("Updated book successfully!", isUpdated);
    }
}
