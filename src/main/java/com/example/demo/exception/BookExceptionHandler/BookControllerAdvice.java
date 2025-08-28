package com.example.demo.exception.BookExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler(BookNotFoundByIdException.class)
    public ResponseEntity<String> handleIdNotFoundException(Exception ex) {
        return new ResponseEntity<>(String.format("Book not found by id - %s", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundByNameException.class)
    public ResponseEntity<String> handleNameNotFoundException(Exception ex) {
        return new ResponseEntity<>(String.format("Book not found by name - %s", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundByAuthorException.class)
    public ResponseEntity<String> BookNotFoundByAuthorException(Exception ex) {
        return new ResponseEntity<>(String.format("Book not found by author - %s", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundByIsbnException.class)
    public ResponseEntity<String> BookNotFoundByIsbnException(Exception ex) {
        return new ResponseEntity<>(String.format("Book not found by isbn - %s", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
