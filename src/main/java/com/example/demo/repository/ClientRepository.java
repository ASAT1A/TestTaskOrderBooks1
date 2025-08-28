package com.example.demo.repository;

import com.example.demo.programObject.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {

    Optional<ClientEntity> findById(UUID id);

    List<ClientEntity> findByName(String name);
}
