package com.tanuja.LibraryManagementSystem.service.impl;

import com.tanuja.LibraryManagementSystem.dto.BorrowDto;
import com.tanuja.LibraryManagementSystem.dto.BorrowSaveDto;
import com.tanuja.LibraryManagementSystem.dto.BorrowUpdateDto;
import com.tanuja.LibraryManagementSystem.entity.Borrow;
import com.tanuja.LibraryManagementSystem.repo.BookRepo;
import com.tanuja.LibraryManagementSystem.repo.BorrowRepo;
import com.tanuja.LibraryManagementSystem.repo.UserRepo;
import com.tanuja.LibraryManagementSystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private BorrowRepo borrowRepo;
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private UserRepo userRepo;

	@Override
	public String addBorrow(BorrowSaveDto borrowSaveDTO) {
		Borrow borrow = new Borrow(
				bookRepo.getById(borrowSaveDTO.getBookId()),
				userRepo.getById(borrowSaveDTO.getUserId()),
				borrowSaveDTO.getBorrowDate(),
				borrowSaveDTO.getReturnDate()
				);
				borrowRepo.save(borrow);
				return null;
	}

	@Override
	public List<BorrowDto> getAllBorrow() {
		List<Borrow> borrowie=borrowRepo.findAll();
		List<BorrowDto> borrowDto=new ArrayList<BorrowDto>();
		for(Borrow b:borrowie){
			BorrowDto dto=new BorrowDto(
					b.getId(),
					b.getBook(),
					b.getUser(),
					b.getBorrowDate(),
					b.getReturnDate()
			);
			borrowDto.add(dto);
		}
		return borrowDto;
	}

	@Override
	public String updateBorrow(BorrowUpdateDto borrowUpdateDto) {
		try{
			if(borrowRepo.existsById(borrowUpdateDto.getId())){
				Borrow borrow=borrowRepo.getById(borrowUpdateDto.getId());
				borrow.setBook(bookRepo.getById(borrowUpdateDto.getBookId()));
				borrow.setUser(userRepo.getById(borrowUpdateDto.getUserId()));
				borrow.setBorrowDate(borrowUpdateDto.getBorrowDate());
				borrow.setReturnDate(borrowUpdateDto.getReturnDate());
				borrowRepo.save(borrow);
				return "Borrow updated successfully";
			}else{
				System.out.println("Borrow not found");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}
