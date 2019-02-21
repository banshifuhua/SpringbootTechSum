package com.eamon.springbootelasticsearchsimple.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author: eamon
 * @date: 2019-01-02 15:57
 * @description: @Document(indexName = "booktest",type = "book")把该类进行索引，其中indexName为索引名称，type为类型，后面的值都可以随便填
 */
@Document(indexName = "springboot-elasticsearch-simple", type = "Book")
public class Book {
    /**
     * 索引的id
     */
    @Id
    private String id;
    private String title;
    private String author;
    private String releaseDate;

    public Book() {
    }

    public Book(String id, String title, String author, String releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
