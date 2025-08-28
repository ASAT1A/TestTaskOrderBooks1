package com.example.demo.exception.BookExceptionHandler;

import java.util.UUID;

public class BookNotFoundByIdException extends RuntimeException{

    public UUID bookid;

    public BookNotFoundByIdException(UUID bookid) {
        this.bookid = bookid;
    }

    @Override
    public String getMessage() {
        return bookid.toString();
    }
}
