package com.tanuja.LibraryManagementSystem.service;

import com.tanuja.LibraryManagementSystem.dto.PublishDto;
import com.tanuja.LibraryManagementSystem.dto.PublishSaveDto;
import com.tanuja.LibraryManagementSystem.dto.PublishUpdateDto;

import java.util.List;

public interface PublishService {
	String addPublisher(PublishSaveDto publishSaveDto);
	List<PublishDto> getAllPublisher();
	String updatePublisher(PublishUpdateDto publishUpdateDto);
	String deletePublisher(int id);
}

