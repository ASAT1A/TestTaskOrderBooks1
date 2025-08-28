package com.example.demo.programObject.mapper.loanMapper;

import com.example.demo.programObject.dto.LoanDto;
import com.example.demo.programObject.entity.LoanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanEntityMapper {

    @Mapping(target = "book", ignore = true)
    @Mapping(target = "client", ignore = true)
    LoanEntity toEntity(LoanDto dto);

    @Mapping(target = "book", ignore = true)
    @Mapping(target = "client", ignore = true)
    List<LoanEntity> toEntities(List<LoanDto> dtos);
}
