package com.tanuja.LibraryManagementSystem.service.impl;

import com.tanuja.LibraryManagementSystem.dto.AuthorDto;
import com.tanuja.LibraryManagementSystem.dto.AuthorSaveDto;
import com.tanuja.LibraryManagementSystem.dto.AuthorUpdateDto;
import com.tanuja.LibraryManagementSystem.entity.Author;
import com.tanuja.LibraryManagementSystem.repo.AuthorRepo;
import com.tanuja.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public   class AuthorServiceImpl implements AuthorService {
   @Autowired
    private  AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }



    @Override
    public String addAuthor(AuthorSaveDto authorSaveDto) {

        Author author=new Author(authorSaveDto.getName());
        authorRepo.save(author);
        return author.getName();

    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors=authorRepo.findAll();
        List<AuthorDto> authorDtos=new ArrayList<>();
        for(Author author:authors){
            AuthorDto authorDto=new AuthorDto(author.getId(),author.getName());
            authorDtos.add(authorDto);
        }

        return  authorDtos;
    }

    @Override
    public String updateAuthor(AuthorUpdateDto authorUpdateDto) {
        if(authorRepo.existsById(authorUpdateDto.getId())){
            Author author=authorRepo.getById(authorUpdateDto.getId());
            author.setName(authorUpdateDto.getName());
            authorRepo.save(author);
            return author.getName();
        }else{
            System.out.println("Author ID not found");
            return null;
        }

    }
    @Override
    public String deleteAuthor(int id) {
        if(authorRepo.existsById(id)){
            authorRepo.deleteById(id);
        }else{
            System.out.println("Author ID not found");
        }
        return null;
    }
}
