package com.tanuja.LibraryManagementSystem.entity;

import jakarta.persistence.*;

import java.util.Set;
@SuppressWarnings("ALL")
@Entity
@Table(name="publisher")
public class Publisher {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="publisher_id",length = 11)
	private int publisherId;;

	@Column(name="name",length=45)
	private String name;

	@OneToMany(mappedBy = "publisher")
	private Set<Book> books;

	public Publisher(int publisherId, String name) {
		this.publisherId = publisherId;
		this.name = name;
	}

	public Publisher() {
	}
	public Publisher( String name) {
		this.name = name;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Publisher{" +
				"publisherId=" + publisherId +
				", name='" + name + '\'' +
				'}';
	}
}
