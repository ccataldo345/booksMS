package com.chris.booksMS.controller;

import com.chris.booksMS.domain.Book;
import com.chris.booksMS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
