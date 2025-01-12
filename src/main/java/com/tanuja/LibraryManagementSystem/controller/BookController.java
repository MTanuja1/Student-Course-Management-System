package com.tanuja.LibraryManagementSystem.controller;

import com.tanuja.LibraryManagementSystem.dto.BookDto;
import com.tanuja.LibraryManagementSystem.dto.BookSaveDto;
import com.tanuja.LibraryManagementSystem.dto.BookUpdateDto;
import com.tanuja.LibraryManagementSystem.entity.Book;
import com.tanuja.LibraryManagementSystem.service.BookService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(path="/save")
	public String saveBook(BookSaveDto bookSaveDto) {
		String book=bookService.addBook(bookSaveDto);
		return "Added Successfully";
	}

	@GetMapping(path="/getAllBook")
	public List<BookDto> getAllBook(){
		List<BookDto> allBooks=bookService.getAllBook();
		return allBooks;
	}

	@PutMapping(path="/update")
	public String updateBook(BookUpdateDto bookUpdateDto) {
		String bookname=bookService.updateBook(bookUpdateDto);
		return bookname;
	}

	@DeleteMapping(path="/delete/{id}")
	public String deleteBook(@PathVariable(value="id") int id){
		String bookname=bookService.deleteBook(id);
		return "deletedddd";
	}
}
