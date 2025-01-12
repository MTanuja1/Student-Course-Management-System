package com.tanuja.LibraryManagementSystem.repo;

import com.tanuja.LibraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
