package com.example.demo.exception.BookExceptionHandler;

public class BookNotFoundByNameException extends RuntimeException {

    public String name;

    public BookNotFoundByNameException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return name;
    }
}
