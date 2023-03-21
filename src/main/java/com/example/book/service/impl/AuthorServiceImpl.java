package com.example.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.book.entity.Author;
import com.example.book.mapper.AuthorMapper;
import com.example.book.service.IAuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements IAuthorService {
}
