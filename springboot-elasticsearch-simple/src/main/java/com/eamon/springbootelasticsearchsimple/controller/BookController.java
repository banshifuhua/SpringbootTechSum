package com.eamon.springbootelasticsearchsimple.controller;

import com.eamon.springbootelasticsearchsimple.entity.Book;
import com.eamon.springbootelasticsearchsimple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author: eamon
 * @date: 2019-01-02 16:08
 * @description:
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/add")
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

    @GetMapping("/query")
    public String query(@RequestParam String id) {
        Book book = bookService.findOne(id);
        return book.toString();
    }

    @GetMapping("/queryAll")
    public Iterable<Book> queryAll() {
        Iterable<Book> all = bookService.findAll();
        return all;
    }

    @GetMapping("/queryByTitle")
    public Page queryByTitle(@RequestParam String title) {
        return bookService.findByTitle(title, PageRequest.of(1, 10));
    }

    @GetMapping("/queryByAuthor")
    public Page queryByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author, PageRequest.of(1, 10));
    }

}
