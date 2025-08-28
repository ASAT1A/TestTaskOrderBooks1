package com.example.demo.programObject.mapper.bookMapper;

import com.example.demo.programObject.dto.BookDto;
import com.example.demo.programObject.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookDtoMapper {

    BookDto toDto(BookEntity entity);

    List<BookDto> toDtos(List<BookEntity> entities);
}
