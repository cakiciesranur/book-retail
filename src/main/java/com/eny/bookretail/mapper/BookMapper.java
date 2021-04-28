package com.eny.bookretail.mapper;

import com.eny.bookretail.dto.request.BookDto;
import com.eny.bookretail.dto.request.UpdateBookDto;
import com.eny.bookretail.dto.response.BookResponse;
import com.eny.bookretail.model.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper extends Converter<BookDto, BookEntity, BookResponse> {
    BookResponse toResource(BookEntity entity);

    BookEntity toEntity(BookDto dto);

    BookEntity toEntity(UpdateBookDto dto);
}