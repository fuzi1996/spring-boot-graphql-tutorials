package com.example.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.book.entity.Book;
import com.example.book.mapper.BookMapper;
import com.example.book.service.IBookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
}
