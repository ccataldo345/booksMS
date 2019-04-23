package com.chris.booksMS.controller;

import com.chris.booksMS.domain.Book;
import com.chris.booksMS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Supplier;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String getAllBooks(Model model) {
        List<Book> allBooks = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", allBooks);
        model.addAttribute("appName", appName);
        return "index";
    }

    @PostMapping("/book/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book book, Model model) throws Throwable {
        Book persistedBook = bookRepository.findById(id).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        });
        persistedBook.setTitle(book.getTitle());
        persistedBook.setIsbn(book.getIsbn());
        persistedBook.setAuthor(book.getAuthor());
        book = bookRepository.save(persistedBook);
        model.addAttribute("book", book);
        return "redirect:/";
    }

    @GetMapping("/book/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) throws Throwable {
        Book book = bookRepository.findById(id).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        });
        model.addAttribute("book", book);
        return "edit-book";
    }

    @PostMapping("/book/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/";
    }

}
