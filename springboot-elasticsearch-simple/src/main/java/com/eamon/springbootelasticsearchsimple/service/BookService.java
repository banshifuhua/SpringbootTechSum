package com.eamon.springbootelasticsearchsimple.service;

import com.eamon.springbootelasticsearchsimple.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author: eamon
 * @date: 2019-01-02 16:03
 * @description:
 */
public interface BookService {
    Book save(Book book);

    void delete(Book book);

    Book findOne(String id);

    Iterable<Book> findAll();

    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    Page<Book> findByTitle(String title, PageRequest pageRequest);
}
