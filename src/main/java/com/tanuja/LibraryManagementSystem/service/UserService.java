package com.tanuja.LibraryManagementSystem.service;

import com.tanuja.LibraryManagementSystem.dto.UserDto;
import com.tanuja.LibraryManagementSystem.dto.UserSaveDto;
import com.tanuja.LibraryManagementSystem.dto.UserUpdateDto;
import com.tanuja.LibraryManagementSystem.entity.User;

import java.util.List;

public interface UserService {
	String addUser(UserSaveDto userSaveDto);

	List<UserDto> getAllUsers();
	String updateUser(UserUpdateDto userUpdateDto);
	String deleteUser(int id);
}
