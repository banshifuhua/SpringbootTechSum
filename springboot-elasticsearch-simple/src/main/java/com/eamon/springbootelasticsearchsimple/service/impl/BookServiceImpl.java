package com.eamon.springbootelasticsearchsimple.service.impl;

import com.eamon.springbootelasticsearchsimple.entity.Book;
import com.eamon.springbootelasticsearchsimple.repo.BookRepository;
import com.eamon.springbootelasticsearchsimple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

    }

    @Override
    public Book findOne(String id) {
        return null;
    }

    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Book> findByTitle(String title, PageRequest pageRequest) {
        return null;
    }
}
