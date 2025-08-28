package com.example.demo.component.WebController;

import com.example.demo.component.service.BookService;
import com.example.demo.programObject.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/web/books")
@RequiredArgsConstructor
public class WebBookController {

    private final BookService bookService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new BookDto());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute BookDto bookDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookService.createBook(bookDto);
        return "redirect:/web/books?success";
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/{id}/change-name")
    public String showChangeNameForm(@PathVariable UUID id, Model model) {
        model.addAttribute("bookId", id);
        return "change-name";
    }

    @PostMapping("/{id}/change-name")
    public String changeName(@PathVariable UUID id, @RequestParam String name) {
        bookService.changeName(id, name);
        return "redirect:/web/books?nameChanged";
    }

    @GetMapping("/{id}/change-author")
    public String showChangeAuthorForm(@PathVariable UUID id, Model model) {
        model.addAttribute("bookId", id);
        return "change-author";
    }

    @PostMapping("/{id}/change-author")
    public String changeAuthor(@PathVariable UUID id, @RequestParam String author) {
        bookService.changeAuthor(id, author);
        return "redirect:/web/books?authorChanged";
    }

    @GetMapping("/{id}/change-isbn")
    public String showChangeIsbnForm(@PathVariable UUID id, Model model) {
        model.addAttribute("bookId", id);
        return "change-isbn";
    }

    @PostMapping("/{id}/change-isbn")
    public String changeIsbn(@PathVariable UUID id, @RequestParam String isbn) {
        bookService.changeIsbn(id, isbn);
        return "redirect:/web/books?isbnChanged";
    }

    @GetMapping("/search/id")
    public String getById(@RequestParam UUID id, Model model) {
        try {
            model.addAttribute("books", bookService.getById(id));
        } catch (Exception e) {
            model.addAttribute("error", "Книга не найдена");
            model.addAttribute("books", Collections.emptyList());
        }
        return "books";
    }

    @GetMapping("/search/name")
    public String getByName(@RequestParam String name, Model model) {
        try {
            model.addAttribute("books", bookService.getByName(name));
        } catch (Exception e) {
            model.addAttribute("error", "Книги не найдены");
            model.addAttribute("books", Collections.emptyList());
        }
        return "books";
    }

    @GetMapping("/search/author")
    public String getByAuthor(@RequestParam String author, Model model) {
        try {
            model.addAttribute("books", bookService.getByAuthor(author));
        } catch (Exception e) {
            model.addAttribute("error", "Книги не найдены");
            model.addAttribute("books", Collections.emptyList());
        }
        return "books";
    }

    @GetMapping("/search/isbn")
    public String getByIsbn(@RequestParam String isbn, Model model) {
        try {
            model.addAttribute("books", bookService.getByIsnb(isbn));
        } catch (Exception e) {
            model.addAttribute("error", "Книга не найдена");
            model.addAttribute("books", Collections.emptyList());
        }
        return "books";
    }
}
