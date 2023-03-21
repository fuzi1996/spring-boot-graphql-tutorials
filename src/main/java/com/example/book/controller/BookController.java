package com.example.book.controller;

import com.example.book.entity.Author;
import com.example.book.entity.Book;
import com.example.book.service.IAuthorService;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IAuthorService authorService;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return this.bookService.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return this.authorService.getById(book.getAuthorId());
    }
}