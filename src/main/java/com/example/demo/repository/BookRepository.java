
package com.example.demo.repository;

import com.example.demo.programObject.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    Optional<BookEntity> findById(UUID id);

    Optional<BookEntity> findByIsbn(String isbn);

    List<BookEntity> findByName(String name);

    List<BookEntity> findByAuthor(String author);
}


