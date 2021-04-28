package com.eny.bookretail.mapper;

public interface Converter<DTO, Entity, Resource> {

    Resource toResource(Entity entity);

    Entity toEntity(DTO dto);

    DTO toDto(Entity entity);
}
