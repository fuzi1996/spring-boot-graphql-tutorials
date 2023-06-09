package com.example.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.book.entity.Author;
import com.example.book.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorMapper extends BaseMapper<Author> {

}
