package com.chris.booksMS.controller;

import com.chris.booksMS.domain.Book;
import com.chris.booksMS.domain.Comment;
import com.chris.booksMS.repository.BookRepository;
import com.chris.booksMS.repository.CommentRepository;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("appName", appName);
        return "index";
    }


    @PostMapping("/book/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/book/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book book, Model model) {
        Book persistedBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No book found with this id"));
        persistedBook.setTitle(book.getTitle());
        persistedBook.setIsbn(book.getIsbn());
        persistedBook.setAuthor(book.getAuthor());
        book = bookRepository.save(persistedBook);
        model.addAttribute("book", book);
        model.addAttribute("comment", new Comment());
        return "redirect:/";
    }

    @GetMapping("/book/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No book found with this id"));
        model.addAttribute("book", book);
        model.addAttribute("appName", appName);
        model.addAttribute("comment", new Comment());
        return "edit-book";
    }

    @PostMapping("/book/{id}/comment")
    public String addComment(@PathVariable("id") Long id, @ModelAttribute Comment comment, Model model) {
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No book found with this id"));
        List<Comment> comments = book.getComments();
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comment.setDate(new Date());
        comment = commentRepository.save(comment);
        comments.add(comment);
        book.setComments(comments);
        bookRepository.save(book);
        model.addAttribute("book", book);
        model.addAttribute("comment", new Comment());
        return "redirect:/book/" + id;
    }

    @GetMapping("/book/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("appName", appName);
        return "add-book";
    }

    @PostMapping("/book/add")
    public String addNewBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }
}
