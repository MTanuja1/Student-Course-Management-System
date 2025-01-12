package com.tanuja.LibraryManagementSystem.service;

import com.tanuja.LibraryManagementSystem.dto.BookDto;
import com.tanuja.LibraryManagementSystem.dto.BookSaveDto;
import com.tanuja.LibraryManagementSystem.dto.BookUpdateDto;

import java.util.List;

public interface BookService {
	String addBook(BookSaveDto bookSaveDto);
	List<BookDto> getAllBook();
	String updateBook(BookUpdateDto bookUpdateDto);
	String deleteBook(int id);
}
