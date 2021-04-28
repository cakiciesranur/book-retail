package com.eny.bookretail.mapper;

import com.eny.bookretail.dto.request.CustomerDto;
import com.eny.bookretail.dto.response.CustomerResponse;
import com.eny.bookretail.model.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends Converter<CustomerDto, CustomerEntity, CustomerResponse> {
    CustomerResponse toResource(CustomerEntity entity);

    CustomerEntity toEntity(CustomerDto dto);
}