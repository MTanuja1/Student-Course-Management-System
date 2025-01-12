package com.tanuja.LibraryManagementSystem.dto;

import com.tanuja.LibraryManagementSystem.entity.Book;
import com.tanuja.LibraryManagementSystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class BorrowDto {

	private int id;
	private Book book;
	private User user;
	private LocalDate borrowDate;
	private LocalDate returnDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public BorrowDto(int id, Book book,  User user, LocalDate borrowDate,LocalDate returnDate) {
		this.id = id;
		this.book = book;
		this.returnDate = returnDate;
		this.user = user;
		this.borrowDate = borrowDate;
	}
}
