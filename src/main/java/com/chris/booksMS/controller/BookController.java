package com.chris.booksMS.controller;

import com.chris.booksMS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

}
