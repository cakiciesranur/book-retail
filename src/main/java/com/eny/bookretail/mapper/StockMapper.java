package com.eny.bookretail.mapper;

import com.eny.bookretail.dto.request.StockDto;
import com.eny.bookretail.dto.response.StockResponse;
import com.eny.bookretail.model.StockEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper extends Converter<StockDto, StockEntity, StockResponse> {
    StockEntity toEntity(StockDto dto);

    StockDto toDto(StockEntity entity);

    StockResponse toResource(StockEntity entity);
}