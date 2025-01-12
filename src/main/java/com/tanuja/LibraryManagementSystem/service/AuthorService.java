package com.tanuja.LibraryManagementSystem.service;

import com.tanuja.LibraryManagementSystem.dto.AuthorDto;
import com.tanuja.LibraryManagementSystem.dto.AuthorSaveDto;
import com.tanuja.LibraryManagementSystem.dto.AuthorUpdateDto;

import java.util.List;

public interface AuthorService {
    public String addAuthor(AuthorSaveDto authorSaveDto);

    public List<AuthorDto> getAllAuthor();

    String updateAuthor(AuthorUpdateDto authorUpdateDto);
    String deleteAuthor(int id);
}
