package com.me.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.entity.Book;
import com.me.mapper.BookMapper;
import com.me.service.BookService;
import com.me.service.dto.BookDTO;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bookDao;

	@Override
	public BookDTO getBookById(int id) {
		BookDTO bookDTO = new BookDTO();
		Book book = bookDao.getBookById(id);
		bookDTO.setId(book.getId());
		bookDTO.setBookName(book.getBookName());
		bookDTO.setBookPrice(book.getBookPrice());
		return bookDTO;
	}

	@Override
	public int addBook(BookDTO book) {
		Book addBook = new Book();
		addBook.setBookName(book.getBookName());
		addBook.setBookPrice(book.getBookPrice());
		bookDao.addBook(addBook);
		return addBook.getId();
	}

	@Override
	public List<BookDTO> getAllBook() {
		List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
		List<Book> bookList = bookDao.getAllBook();

		for (Book item : bookList) {
			BookDTO uDto = new BookDTO();
			uDto.setId(item.getId());
			uDto.setBookName(item.getBookName());
			uDto.setBookPrice(item.getBookPrice());
			bookDTOList.add(uDto);
		}

		return bookDTOList;
	}

	@Override
	public Integer deleteBookById(int id) {
        Integer count= bookDao.deleteBookById(id);
		return count;
	}

	@Override
	public Integer updateBook(BookDTO book) {

		Book updateBook = new Book();
		updateBook.setId(book.getId());
		updateBook.setBookName(book.getBookName());
		updateBook.setBookPrice(book.getBookPrice());


		return bookDao.updateBook(updateBook);

	}
	

}
