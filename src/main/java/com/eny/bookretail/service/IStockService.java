package com.eny.bookretail.service;

import com.eny.bookretail.dto.request.StockDto;
import com.eny.bookretail.dto.response.StockResponse;
import com.eny.bookretail.model.BookEntity;
import com.eny.bookretail.model.StockEntity;

public interface IStockService {
    StockEntity createStock(StockDto dto);

    StockEntity getStockInfoByBook(BookEntity bookEntity);

    boolean isStockAvailable(BookEntity entity, int quantity);

    boolean decreaseStockQuantity(BookEntity book, int amount);

    StockResponse getStockInfoByBookId(long id);

    StockResponse getStockById(long id);

    boolean updateStockById(long id, StockDto dto);

    boolean updateStockByBookId(long bookId, StockDto dto);

    boolean increaseStockByBookId(Long bookId, int quantity);
}
