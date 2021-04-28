package com.eny.bookretail.controller;

import com.eny.bookretail.dto.request.StockDto;
import com.eny.bookretail.dto.response.GenericResponse;
import com.eny.bookretail.dto.response.StockResponse;
import com.eny.bookretail.service.GenericResponseService;
import com.eny.bookretail.service.IStockService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private IStockService stockService;

    @Autowired
    private GenericResponseService genericResponseService;

    @GetMapping("/{id}")
    @ApiOperation(value = "This gets stock info by id")
    public GenericResponse getStockById(@PathVariable("id") long id) {
        StockResponse response = stockService.getStockById(id);
        return genericResponseService.createResponseNoError(" ", response);
    }

    @GetMapping("/getStockByBook/{id}")
    @ApiOperation(value = "This gets stock info by book id")
    public GenericResponse getStockByBookId(@PathVariable("id") long id) {
        StockResponse response = stockService.getStockInfoByBookId(id);
        return genericResponseService.createResponseNoError(" ", response);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "This updates stock by id")
    public GenericResponse updateStockById(@PathVariable("id") long id, @Valid @RequestBody StockDto dto) {
        boolean isUpdated = stockService.updateStockById(id, dto);
        return genericResponseService.createResponseNoError("Updated stock successfully! ", isUpdated);
    }

    @PutMapping("/updateByBookId/{bookId}")
    @ApiOperation(value = "This updates stock by book id")
    public GenericResponse updateStockByBookId(@PathVariable("bookId") long bookId, @Valid @RequestBody StockDto dto) {
        boolean isUpdated = stockService.updateStockByBookId(bookId, dto);
        return genericResponseService.createResponseNoError("Updated stock successfully! ", isUpdated);
    }
}
