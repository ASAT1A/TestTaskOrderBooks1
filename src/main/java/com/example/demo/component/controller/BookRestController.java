package com.example.demo.component.controller;

import com.example.demo.component.service.BookService;
import com.example.demo.programObject.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.OK);
    }

    @PatchMapping("/changeName")
    public ResponseEntity<BookDto> changeName(@Valid @RequestParam("book_id") UUID bookid, @RequestParam("name") String name) {
        return new ResponseEntity<>(bookService.changeName(bookid, name), HttpStatus.OK);
    }

    @PatchMapping("/changeAuthor")
    public ResponseEntity<BookDto> changeAuthor(@Valid @RequestParam("book_id") UUID bookid, @RequestParam("author") String author) {
        return new ResponseEntity<>(bookService.changeAuthor(bookid, author), HttpStatus.OK);
    }

    @PatchMapping("/changeIsbn")
    public ResponseEntity<BookDto> changeIsbn(@Valid @RequestParam("book_id") UUID bookid, @RequestParam("isbn") String isbn) {
        return new ResponseEntity<>(bookService.changeIsbn(bookid, isbn), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookDto>> getAll() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<List<BookDto>> getById(@Valid @RequestParam("client_id") UUID id) {
        return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<BookDto>> getByName(@Valid @RequestParam("name") String name) {
        return new ResponseEntity<>(bookService.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/getByAuthor")
    public ResponseEntity<List<BookDto>> getByAuthor(@Valid @RequestParam("author") String author) {
        return new ResponseEntity<>(bookService.getByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/getByIsbn")
    public ResponseEntity<List<BookDto>> getByIsbn(@Valid @RequestParam("isbn") String isbn) {
        return new ResponseEntity<>(bookService.getByIsnb(isbn), HttpStatus.OK);
    }
}