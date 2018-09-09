package com.me.mapper;

import java.util.List;

import com.me.entity.Book;


public interface BookMapper {
	public Book getBookById(int id);
	public int addBook(Book book);
	public List<Book> getAllBook();
	public Integer deleteBookById(int id);
	public Integer updateBook(Book book);
}
