package com.tanuja.LibraryManagementSystem.service.impl;

import com.tanuja.LibraryManagementSystem.dto.PublishDto;
import com.tanuja.LibraryManagementSystem.dto.PublishSaveDto;
import com.tanuja.LibraryManagementSystem.dto.PublishUpdateDto;
import com.tanuja.LibraryManagementSystem.entity.Publisher;
import com.tanuja.LibraryManagementSystem.repo.PublisherRepo;
import com.tanuja.LibraryManagementSystem.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PublishServiceImpl implements PublishService {

	@Autowired
	private PublisherRepo publisherRepo;

	@Override
	public String addPublisher(PublishSaveDto publishSaveDto) {
		Publisher publisher = new Publisher(publishSaveDto.getName());
		publisherRepo.save(publisher);
		return publisher.getName();
	}

	@Override
	public List<PublishDto> getAllPublisher() {
		List<Publisher> getPublishers = publisherRepo.findAll();
		List<PublishDto> publisherDtoList = new ArrayList<PublishDto>();
		for(Publisher publisher : getPublishers) {
			PublishDto publishDto = new PublishDto(
					publisher.getPublisherId(),publisher.getName());
			publisherDtoList.add(publishDto);
		}
		return publisherDtoList;
	}

	@Override
	public String updatePublisher(PublishUpdateDto publishUpdateDto) {
		if(publisherRepo.existsById(publishUpdateDto.getPublishId())){
			Publisher publisher=publisherRepo.findById(publishUpdateDto.getPublishId()).get();
			publisher.setName(publishUpdateDto.getName());
			publisherRepo.save(publisher);
			return publisher.getName();
		}else{
			System.out.println("publisher not exist");
			return null;
		}
	}

	@Override
	public String deletePublisher(int id) {
		if(publisherRepo.existsById(id)){
			publisherRepo.deleteById(id);
		}else{
			System.out.println("publisher not exist");
		}
		return null;
	}
}
