package com.example.demo.programObject.mapper.clientMapper;

import com.example.demo.programObject.dto.ClientDto;
import com.example.demo.programObject.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientEntityMapper {
    ClientEntity toEntity(ClientDto dto);

    List<ClientEntity> toEntities(List<ClientDto> dtos);
}
