package com.example.demo;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="books_seq")
    @SequenceGenerator(name="books_seq",
            sequenceName="SEQ_USERS", allocationSize=1)
    @Column(name="id")
    private Long id;
    @Column(name="author")
    private String author;
    @Column(name="title")
    private String title;

    public Book() {
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
