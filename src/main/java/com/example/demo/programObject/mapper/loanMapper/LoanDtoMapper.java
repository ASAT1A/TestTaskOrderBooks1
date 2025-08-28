package com.example.demo.programObject.mapper.loanMapper;

import com.example.demo.programObject.dto.LoanDto;
import com.example.demo.programObject.entity.LoanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanDtoMapper {

    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "client.id", target = "clientId")
    LoanDto toDto(LoanEntity entity);

    List<LoanDto> toDtos(List<LoanEntity> entities);
}


