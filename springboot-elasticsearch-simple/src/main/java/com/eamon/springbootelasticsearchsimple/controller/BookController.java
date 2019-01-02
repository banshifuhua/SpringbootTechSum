package com.eamon.springbootelasticsearchsimple.controller;

import com.eamon.springbootelasticsearchsimple.entity.Book;
import com.eamon.springbootelasticsearchsimple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: eamon
 * @date: 2019-01-02 16:08
 * @description:
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String add(@RequestParam String id) {
        Book book = new Book();
        book.setId(id);
        book.setAuthor("eamon");
        book.setReleaseDate(String.valueOf(System.currentTimeMillis()));
        book.setTitle("ADD");
        Book save = bookService.save(book);
        return save.toString();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String id) {
        Book book = new Book();
        book.setId(id);
        bookService.delete(book);
        return "success";
    }

}
