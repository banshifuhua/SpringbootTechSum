package com.eamon.springbootelasticsearchsimple.service.impl;

import com.eamon.springbootelasticsearchsimple.entity.Book;
import com.eamon.springbootelasticsearchsimple.repo.BookRepository;
import com.eamon.springbootelasticsearchsimple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: eamon
 * @date: 2019-01-02 16:04
 * @description:
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book findOne(String id) {
        Optional<Book> optional = bookRepository.findById(id);
        boolean present = optional.isPresent();
        Book book = null;
        if (present) {
            book = optional.get();
        }
        return book;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    @Override
    public Page<Book> findByTitle(String title, PageRequest pageRequest) {
        return bookRepository.findByTitle(title, pageRequest);
    }
}
