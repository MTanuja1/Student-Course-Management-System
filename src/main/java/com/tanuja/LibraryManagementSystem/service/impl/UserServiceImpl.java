package com.tanuja.LibraryManagementSystem.service.impl;

import com.tanuja.LibraryManagementSystem.dto.UserDto;
import com.tanuja.LibraryManagementSystem.dto.UserSaveDto;
import com.tanuja.LibraryManagementSystem.dto.UserUpdateDto;
import com.tanuja.LibraryManagementSystem.entity.User;
import com.tanuja.LibraryManagementSystem.repo.UserRepo;
import com.tanuja.LibraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public String addUser(UserSaveDto userSaveDto) {
		User newUser = new User(
				userSaveDto.getName(),
				userSaveDto.getEmail()
		);
		userRepo.save(newUser);
		return newUser.getName();
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=userRepo.findAll();
		List<UserDto> userDtos=new ArrayList<>();
		for(User user:users){
			UserDto userDto=new UserDto(
					user.getId(),
					user.getName(),
					user.getEmail()
			);
			userDtos.add(userDto);
		}
		return userDtos;
	}

	@Override
	public String updateUser(UserUpdateDto userUpdateDto) {
		if(userRepo.existsById(userUpdateDto.getUser_id())){
			User user=userRepo.getById(userUpdateDto.getUser_id());
			user.setName(userUpdateDto.getName());
			user.setEmail(userUpdateDto.getEmail());
			userRepo.save(user);
		}else{
			System.out.println("user not found");
		}
		return  null;
	}

	@Override
	public String deleteUser(int id) {
		if(userRepo.existsById(id)){
			userRepo.deleteById(id);
		}else{
			System.out.println("user not found");
		}
		return null;
	}
}
