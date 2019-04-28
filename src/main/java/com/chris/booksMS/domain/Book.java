package com.chris.booksMS.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // https://stackoverflow.com/questions/39807483/sequence-hibernate-sequence-not-found-sql-statement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Comment> comments;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
