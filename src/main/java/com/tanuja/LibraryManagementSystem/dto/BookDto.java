package com.tanuja.LibraryManagementSystem.dto;

import com.tanuja.LibraryManagementSystem.entity.Author;
import com.tanuja.LibraryManagementSystem.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class BookDto {
	private int bookid;
	private String title;
	private Author author;
	private Publisher publisher;

	public BookDto(int bookid, String title, Author author, Publisher publisher) {
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}
