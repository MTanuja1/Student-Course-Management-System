package com.tanuja.LibraryManagementSystem.service;

import com.tanuja.LibraryManagementSystem.dto.BorrowDto;
import com.tanuja.LibraryManagementSystem.dto.BorrowSaveDto;
import com.tanuja.LibraryManagementSystem.dto.BorrowUpdateDto;

import java.util.List;

public interface BorrowService {
	String addBorrow(BorrowSaveDto borrowSaveDto);
	List<BorrowDto> getAllBorrow();
	String  updateBorrow(BorrowUpdateDto borrowUpdateDto);
}
