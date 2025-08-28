package com.example.demo.programObject.mapper.clientMapper;

import com.example.demo.programObject.dto.ClientDto;
import com.example.demo.programObject.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientDtoMapper {

    ClientDto toDto(ClientEntity entity);

    List<ClientDto> toDtos(List<ClientEntity> entities);
}