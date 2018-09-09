package com.me.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.controller.framework.BaseController;
import com.me.controller.viewobject.ApiResult;
import com.me.controller.viewobject.BookVO;
import com.me.service.BookService;
import com.me.service.dto.BookDTO;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController{
	
	@Autowired
	private BookService bookService;
	

	@RequestMapping(value = "/bookinfo/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ApiResult getBookById(@PathVariable("id") int id) {
		int bookId = id;
		ApiResult apiResult = new ApiResult();
		BookDTO book = new BookDTO();
		book = bookService.getBookById(bookId);

		apiResult.setIsSuccess(true);
		apiResult.setMessage("success");
		apiResult.setData(book);

		return apiResult;
	}
	
	@RequestMapping(value = "/showallbook", method = RequestMethod.GET)
	@ResponseBody
	public ApiResult showAllBook(HttpServletRequest request,HttpServletResponse response) {

		ApiResult apiResult = new ApiResult();
		BookDTO bookDTO = new BookDTO();
		List<BookVO> bookVOList = new ArrayList<BookVO>();
		List<BookDTO> bookList = bookService.getAllBook();
		
		for(BookDTO item : bookList){
			BookVO bookVO = new BookVO();
			bookVO.setId(item.getId());
			bookVO.setBookName(item.getBookName());
			bookVO.setBookPrice(item.getBookPrice());
			bookVOList.add(bookVO);
		}
		
		apiResult.setIsSuccess(true);
		apiResult.setMessage("success");
		apiResult.setData(bookVOList);
		
		return apiResult;
	}
	
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public ApiResult addBook(HttpServletRequest request,@Valid @ModelAttribute BookVO book,BindingResult result) {
		ApiResult apiResult = new ApiResult();
		List<ObjectError> allErrors=null;
		String message="";
		Boolean isSuccess=true;
		
		if(result.hasErrors()){
			logger.error("===========================add book valid error");
			isSuccess=false;
			message="validation error";
			allErrors = result.getAllErrors();
		}
	
		Date date = new Date();
		BookDTO addBook = new BookDTO();
		addBook.setBookName(book.getBookName());
		addBook.setBookPrice(book.getBookPrice());

		int bookId = bookService.addBook(addBook);
		
		apiResult.setIsSuccess(isSuccess);
		apiResult.setMessage(message);
		apiResult.setData(allErrors);
		 
		return apiResult;
	}
	
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ApiResult deleteBookById(@PathVariable("id") int id) {
		ApiResult apiResult = new ApiResult();
		bookService.deleteBookById(id);
		
		apiResult.setIsSuccess(true);
		apiResult.setMessage("success");
		apiResult.setData(null);

		return apiResult;
	}

	@RequestMapping(value = "/updatebook", method = RequestMethod.PUT)
	public ApiResult updateBook(HttpServletRequest request,@Valid @ModelAttribute BookVO book,BindingResult result) {
		ApiResult apiResult = new ApiResult();
		List<ObjectError> allErrors=null;
		String message="";
		Boolean isSuccess=true;
		
		if(result.hasErrors()){
			isSuccess=false;
			message="validation error";
			allErrors = result.getAllErrors();
		}
	
		BookDTO updateBook = new BookDTO();
		updateBook.setId(book.getId());
		updateBook.setBookName(book.getBookName());
		updateBook.setBookPrice(book.getBookPrice());
		int bookId = bookService.updateBook(updateBook);
		
		apiResult.setIsSuccess(isSuccess);
		apiResult.setMessage(message);
		apiResult.setData(allErrors);
		 
		return apiResult;
	}
	
	
	
}
