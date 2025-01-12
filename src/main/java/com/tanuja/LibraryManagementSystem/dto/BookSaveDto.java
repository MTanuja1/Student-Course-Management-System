package com.tanuja.LibraryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BookSaveDto {
	private String title;
	private int author_id;
	private int publisher_id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public int getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}

	@Override
	public String toString() {
		return "BookSaveDto{" +
				"title='" + title + '\'' +
				", author_id=" + author_id +
				", publisher_id=" + publisher_id +
				'}';
	}
}
