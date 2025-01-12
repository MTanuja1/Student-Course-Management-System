package com.tanuja.LibraryManagementSystem.controller;

import com.tanuja.LibraryManagementSystem.dto.AuthorDto;
import com.tanuja.LibraryManagementSystem.dto.UserDto;
import com.tanuja.LibraryManagementSystem.dto.UserSaveDto;
import com.tanuja.LibraryManagementSystem.dto.UserUpdateDto;
import com.tanuja.LibraryManagementSystem.repo.UserRepo;
import com.tanuja.LibraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepo userRepo;

	@PostMapping(path="/save")
	public String saveUser(@RequestBody UserSaveDto userSaveDto) {
		String user=userService.addUser(userSaveDto);
		return "added new user successfully";
	}

	@GetMapping(path="getAllUsers")
	public List<UserDto> getAllUser(){
		List<UserDto> allUsers=userService.getAllUsers();
		return allUsers;
	}

	@PutMapping("/update")
	public String updateUser(@RequestBody UserUpdateDto userUpdateDto) {
		String name=userService.updateUser(userUpdateDto);
		return name;
	}

	public String deleteUser(int id){
		String user=userService.deleteUser(id);
		return "deleteddd";
	}
}
