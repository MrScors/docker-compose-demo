package com.example.demo.control;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    BookRepo bookRepo;

    @GetMapping(path = "/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping(path = "/read")
    public List<String> readBooks() {
        List<String> books = new ArrayList<String>();
        for (Book b : bookRepo.findAll()) {
            books.add(b.toString());
        }
        return books;
    }

    @GetMapping(path = "/create")
    public String createBook(@QueryParam("author") String author,
                             @QueryParam("title") String title) {
        Book book = new Book(author, title);
        try {
            bookRepo.save(book);
        } catch (Exception e) {
            return "Error";
        }
        return "Book created";
    }

}
