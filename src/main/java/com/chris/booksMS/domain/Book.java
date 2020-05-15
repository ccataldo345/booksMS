package com.chris.booksMS.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 50, message="Please do not exceed 50 characters.")
    private String title;

    @Size(max = 30, message="Please do not exceed 30 characters.")
    private String author;

    @Size(max = 15)
    private String isbn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<Comment> comments;
}
