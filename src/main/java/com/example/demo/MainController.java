package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    BookRepo bookRepo;

    @GetMapping(path="/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping(path="/read")
    public List<Book> readBooks(){
        return (List<Book>) bookRepo.findAll();
    }

    @GetMapping(path="/create")
    public String createBook(@QueryParam("author") String author,
                              @QueryParam("title") String title){
        Book book = new Book(author, title);
        try{
           bookRepo.save(book);
        }
        catch(Exception e){
            return "Error";
        }
        return "Book created";
    }

}
