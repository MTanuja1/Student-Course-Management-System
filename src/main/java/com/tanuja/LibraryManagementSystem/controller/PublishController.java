package com.tanuja.LibraryManagementSystem.controller;

import com.tanuja.LibraryManagementSystem.dto.PublishSaveDto;
import com.tanuja.LibraryManagementSystem.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("app/v1/publisher")
public class PublishController {

	@Autowired
	private PublishService publishService;

	@PostMapping(path="/save")
	public String savePublisher(PublishSaveDto publishSaveDto) {
		String publlisherName=publishService.addPublisher(publishSaveDto);
		return "Added Successfully";
	}
}
