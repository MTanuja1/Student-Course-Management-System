package com.tanuja.LibraryManagementSystem.repo;

import com.tanuja.LibraryManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
