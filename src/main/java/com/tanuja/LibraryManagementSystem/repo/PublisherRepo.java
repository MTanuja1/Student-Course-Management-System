package com.tanuja.LibraryManagementSystem.repo;

import com.tanuja.LibraryManagementSystem.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
