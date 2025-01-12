package com.tanuja.LibraryManagementSystem.controller;

import com.tanuja.LibraryManagementSystem.dto.BorrowDto;
import com.tanuja.LibraryManagementSystem.dto.BorrowSaveDto;
import com.tanuja.LibraryManagementSystem.dto.BorrowUpdateDto;
import com.tanuja.LibraryManagementSystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/borrow")
public class BorrowController {
	@Autowired
	private BorrowService borrowService;

	@PostMapping(path="/save")
	public String saveBorroe(@RequestBody BorrowSaveDto borrowSaveDto) {
		String borrowBooks=borrowService.addBorrow(borrowSaveDto);
		return "borrower added successfully";
	}

	@GetMapping(path="/getAllBorrow")
	public List<BorrowDto> getAllBorrow(){
		List<BorrowDto> allborrowie=borrowService.getAllBorrow();
		return allborrowie;
	}

	@PutMapping(path="/update")
	public String updateBorrow(@RequestBody BorrowUpdateDto borrowUpdateDto) {
		String borrow=borrowService.updateBorrow(borrowUpdateDto);
		return "updated";
	}
}
