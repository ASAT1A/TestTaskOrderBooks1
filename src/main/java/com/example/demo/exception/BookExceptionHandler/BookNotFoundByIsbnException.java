package com.example.demo.exception.BookExceptionHandler;

public class BookNotFoundByIsbnException extends RuntimeException {

    public String name;

    public BookNotFoundByIsbnException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return name;
    }
}
