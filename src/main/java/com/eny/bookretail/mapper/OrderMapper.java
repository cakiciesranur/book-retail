package com.eny.bookretail.mapper;

import com.eny.bookretail.dto.request.OrderDto;
import com.eny.bookretail.dto.response.OrderResponse;
import com.eny.bookretail.model.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends Converter<OrderDto, OrderEntity, OrderResponse> {
    OrderEntity toEntity(OrderDto dto);

    OrderResponse toResource(OrderEntity entity);


}