package com.example.demo.component.service;

import com.example.demo.exception.BookExceptionHandler.BookNotFoundByAuthorException;
import com.example.demo.exception.BookExceptionHandler.BookNotFoundByIdException;
import com.example.demo.exception.BookExceptionHandler.BookNotFoundByNameException;
import com.example.demo.programObject.dto.BookDto;
import com.example.demo.programObject.entity.BookEntity;
import com.example.demo.programObject.mapper.bookMapper.BookDtoMapper;
import com.example.demo.programObject.mapper.bookMapper.BookEntityMapper;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final BookDtoMapper bookDtoMapper;
    private final BookEntityMapper bookEntityMapper;

    public BookDto createBook(BookDto bookDto) {
        BookEntity bookEntity = bookEntityMapper.toEntity(bookDto);
        bookRepository.save(bookEntity);
        return bookDtoMapper.toDto(bookEntity);
    }

    public BookDto changeName(UUID bookid, String name) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(bookid);
        if (bookEntityOptional.isPresent()) {
            bookEntityOptional.get().setName(name);
            bookRepository.save(bookEntityOptional.get());
            return bookDtoMapper.toDto(bookEntityOptional.get());
        } else {
            throw new RuntimeException();
        }
    }

    public BookDto changeAuthor(UUID bookid, String author) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(bookid);
        if (bookEntityOptional.isPresent()) {
            bookEntityOptional.get().setAuthor(author);
            bookRepository.save(bookEntityOptional.get());
            return bookDtoMapper.toDto(bookEntityOptional.get());
        } else {
            throw new RuntimeException();
        }
    }

    public BookDto changeIsbn(UUID bookid, String isbn) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(bookid);
        if (bookEntityOptional.isPresent()) {
            bookEntityOptional.get().setIsbn(isbn);
            bookRepository.save(bookEntityOptional.get());
            return bookDtoMapper.toDto(bookEntityOptional.get());
        } else {
            throw new RuntimeException();
        }
    }

    public List<BookDto> getAllBooks() {

        List<BookEntity> bookEntities = new ArrayList<>();
        bookEntities.addAll(bookRepository.findAll());
        return bookDtoMapper.toDtos(bookEntities);
    }

    public List<BookDto> getById(UUID bookid) {

        Optional<BookEntity> bookEntityOptional = bookRepository.findById(bookid);

        if (bookEntityOptional.isPresent()) {
            return Collections.singletonList(bookDtoMapper.toDto(bookEntityOptional.get()));
        } else {
            throw new BookNotFoundByIdException(bookid);
        }
    }

    public List<BookDto> getByName(String name) {

        List<BookEntity> bookEntityData = bookRepository.findByName(name);

        if (!bookEntityData.isEmpty()) {
            return bookDtoMapper.toDtos(bookEntityData);
        } else {
            throw new BookNotFoundByNameException(name);
        }
    }

    public List<BookDto> getByAuthor(String author) {

        List<BookEntity> bookEntityData = bookRepository.findByAuthor(author);

        if (!bookEntityData.isEmpty()) {
            return bookDtoMapper.toDtos(bookEntityData);
        } else {
            throw new BookNotFoundByAuthorException(author);
        }
    }

    public List<BookDto> getByIsnb(String isbn) {

        Optional<BookEntity> bookEntityOptional = bookRepository.findByIsbn(isbn);

        if (bookEntityOptional.isPresent()) {
            return Collections.singletonList(bookDtoMapper.toDto(bookEntityOptional.get()));
        } else {
            throw new RuntimeException();
        }
    }
}

