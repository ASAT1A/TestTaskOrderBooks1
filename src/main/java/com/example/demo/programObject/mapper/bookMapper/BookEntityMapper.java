package com.example.demo.programObject.mapper.bookMapper;

import com.example.demo.programObject.dto.BookDto;
import com.example.demo.programObject.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookEntityMapper {

    BookEntity toEntity(BookDto dto);

    List<BookEntity> toEntities(List<BookDto> dtos);
}
