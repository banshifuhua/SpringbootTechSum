package com.eamon.springbootelasticsearchsimple.repo;

import com.eamon.springbootelasticsearchsimple.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: eamon
 * @date: 2019-01-02 15:59
 * @description:
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    Optional<Book> findById(String id);

    Page<Book> findByAuthor(String author, Pageable pageable);

    Page<Book> findByTitle(String title, Pageable pageable);

}
