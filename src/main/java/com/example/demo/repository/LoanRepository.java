package com.example.demo.repository;

import com.example.demo.programObject.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoanRepository extends JpaRepository<LoanEntity, UUID> {

    Optional<LoanEntity> findById(UUID id);

    @Query("SELECT l FROM LoanEntity l " +
            "JOIN FETCH l.client c " +
            "JOIN FETCH l.book b " +
            "ORDER BY c.name, l.loanDate")
    List<LoanEntity> findAllWithClientAndBook();

}
