package com.tanuja.LibraryManagementSystem.repo;

import com.tanuja.LibraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AuthorRepo extends JpaRepository<Author, Integer> {



}
