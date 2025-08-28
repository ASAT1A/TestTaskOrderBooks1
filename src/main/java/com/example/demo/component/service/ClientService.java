package com.example.demo.component.service;

import com.example.demo.programObject.dto.ClientDto;
import com.example.demo.programObject.entity.ClientEntity;
import com.example.demo.programObject.mapper.clientMapper.ClientDtoMapper;
import com.example.demo.programObject.mapper.clientMapper.ClientEntityMapper;
import com.example.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    private final ClientDtoMapper clientDtoMapper;
    private final ClientEntityMapper clientEntityMapper;

    public ClientDto createClient(ClientDto clientDto) {
        ClientEntity createEntity = clientEntityMapper.toEntity(clientDto);
        clientRepository.save(createEntity);
        return clientDtoMapper.toDto(createEntity);
    }

    public ClientDto changeName(UUID clientid, String name) {
        Optional<ClientEntity> clientEntityOptional = clientRepository.findById(clientid);
        if (clientEntityOptional.isPresent()) {
            clientEntityOptional.get().setName(name);
            clientRepository.save(clientEntityOptional.get());
            return clientDtoMapper.toDto(clientEntityOptional.get());
        } else {
            throw new RuntimeException();
        }
    }

    public ClientDto changeBirthday(UUID clientid, LocalDate birthday) {
        Optional<ClientEntity> clientEntityOptional = clientRepository.findById(clientid);
        if (clientEntityOptional.isPresent()) {
            clientEntityOptional.get().setBirthdate(birthday);
            clientRepository.save(clientEntityOptional.get());
            return clientDtoMapper.toDto(clientEntityOptional.get());
        } else {
            throw new RuntimeException();
        }
    }

    public List<ClientDto> getAllClients() {

        List<ClientEntity> clientEntities = new ArrayList<>();
        clientEntities.addAll(clientRepository.findAll());
        return clientDtoMapper.toDtos(clientEntities);
    }

    public List<ClientDto> getById(UUID clientid) {

        Optional<ClientEntity> clientEntityOptional = clientRepository.findById(clientid);

        if (clientEntityOptional.isPresent()) {
            return Collections.singletonList(clientDtoMapper.toDto(clientEntityOptional.get()));
        } else {
            throw new RuntimeException();
        }
    }

    public List<ClientDto> getByName(String name) {

        List<ClientEntity> clientEntity = clientRepository.findByName(name);

        if (!clientEntity.isEmpty()) {
            return clientDtoMapper.toDtos(clientEntity);
        } else {
            throw new RuntimeException();
        }
    }
}