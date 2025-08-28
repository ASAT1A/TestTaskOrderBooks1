package com.example.demo.programObject.mapper.loanInfoMapper;

import com.example.demo.programObject.dto.LoanInfoDto;
import com.example.demo.programObject.entity.LoanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InfoDtoMapper {

    @Mapping(source = "client.name", target = "clientName")
    @Mapping(source = "client.birthdate", target = "clientBirthdate")
    @Mapping(source = "book.name", target = "bookName")
    @Mapping(source = "book.author", target = "bookAuthor")
    @Mapping(source = "book.isbn", target = "bookIsbn")
    @Mapping(source = "loanDate", target = "loanDate")
    LoanInfoDto toLoanInfoDto(LoanEntity loanEntity);

    List<LoanInfoDto> toLoanInfoDtos(List<LoanEntity> loanEntities);
}
