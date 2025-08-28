package com.example.demo.exception.BookExceptionHandler;

public class BookNotFoundByAuthorException extends RuntimeException {

    public String author;

    public BookNotFoundByAuthorException(String author) {
        this.author = author;
    }

    @Override
    public String getMessage() {
        return author;
    }
}
