package com.tanuja.LibraryManagementSystem.repo;

import com.tanuja.LibraryManagementSystem.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepo extends JpaRepository<Borrow, Integer> {
}
