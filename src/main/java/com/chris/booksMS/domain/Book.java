package com.chris.booksMS.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String isbn;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Comment> comments;
}
