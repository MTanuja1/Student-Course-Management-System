package com.tanuja.LibraryManagementSystem.service.impl;

import com.tanuja.LibraryManagementSystem.dto.BookDto;
import com.tanuja.LibraryManagementSystem.dto.BookSaveDto;
import com.tanuja.LibraryManagementSystem.dto.BookUpdateDto;
import com.tanuja.LibraryManagementSystem.entity.Book;
import com.tanuja.LibraryManagementSystem.repo.AuthorRepo;
import com.tanuja.LibraryManagementSystem.repo.BookRepo;
import com.tanuja.LibraryManagementSystem.repo.PublisherRepo;
import com.tanuja.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private AuthorRepo authorRepo;
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private PublisherRepo publisherRepo;

	@Override
	public String addBook(BookSaveDto bookSaveDto) {
		Book book=new Book(bookSaveDto.getTitle(),
				authorRepo.getById(bookSaveDto.getAuthor_id()),
				publisherRepo.getById(bookSaveDto.getPublisher_id()));
		bookRepo.save(book);
		return book.getTitle();
	}

	@Override
	public List<BookDto> getAllBook() {
		List<Book> getBooks=bookRepo.findAll();
		List<BookDto> bookDtoList=new ArrayList<>();
		for(Book book:getBooks){
			BookDto bookDto=new BookDto(
					book.getBookid(),
					book.getTitle(),
					book.getAuthor(),
					book.getPublisher()
			);
			bookDtoList.add(bookDto);
		}
		return bookDtoList;
	}

	@Override
	public String updateBook(BookUpdateDto bookUpdateDto) {
		if(bookRepo.existsById(bookUpdateDto.getBookid())){
			Book book=bookRepo.getById(bookUpdateDto.getBookid());
			book.setTitle(bookUpdateDto.getTitle());
			book.setAuthor(authorRepo.getById(bookUpdateDto.getAuthor_id()));
			book.setPublisher(publisherRepo.getById(bookUpdateDto.getPublisher_id()));
			bookRepo.save(book);
			return book.getTitle();
		}else{
			System.out.println("Book Id not found");
		}
		return null;
	}

	@Override
	public String deleteBook(int id) {
		if(bookRepo.existsById(id)){
			bookRepo.deleteById(id);
		}else{
			System.out.println("Book Id not found");
		}
		return null;
	}
}
