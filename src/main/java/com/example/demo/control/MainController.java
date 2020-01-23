package com.example.demo.control;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    final
    BookRepo bookRepo;

    public MainController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

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

    @PostMapping(path = "/create")
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


    @PutMapping(path = "/update")
    public String updateBook(@RequestParam("id") Long id,
                             @RequestParam(defaultValue = "none") String author,
                             @RequestParam(defaultValue = "none") String title){
        try {

            Book book = bookRepo.findById(id).orElse(null);
            assert book != null;

            if (!author.intern().equals("none")) {
                book.setAuthor(author);
            }
            if (!title.intern().equals("none")) {
                book.setTitle(title);
            }
            bookRepo.save(book);

        } catch (AssertionError e) {
            return "Failed to find book";
        } catch (Exception e) {
            return e.toString();
        }

        return "Updated";
    }

    @DeleteMapping(path = "/deleteByAuthor")
    public String deleteBookByAuthor(@QueryParam("author") String author) {
        try {
            bookRepo.deleteByAuthor(author);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "Deleted";
    }

}
