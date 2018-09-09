package com.me.service;

import java.util.List;

import com.me.service.dto.BookDTO;

public interface BookService {
	public BookDTO getBookById(int id);
	public int addBook(BookDTO book);
	public List<BookDTO> getAllBook();
	public Integer deleteBookById(int id);
	public Integer updateBook(BookDTO book);
}
