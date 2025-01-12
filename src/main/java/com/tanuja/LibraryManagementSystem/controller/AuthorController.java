package com.tanuja.LibraryManagementSystem.controller;

import com.tanuja.LibraryManagementSystem.dto.AuthorDto;
import com.tanuja.LibraryManagementSystem.dto.AuthorSaveDto;
import com.tanuja.LibraryManagementSystem.dto.AuthorUpdateDto;
import com.tanuja.LibraryManagementSystem.entity.Author;
import com.tanuja.LibraryManagementSystem.service.AuthorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/save")
    public String saveAuthor(@RequestBody AuthorSaveDto authorSaveDto) {
        String authorName=authorService.addAuthor(authorSaveDto);
        return "Added successfully";
    }
    @GetMapping(path="/getAllAuthors")
    public List<AuthorDto> getAllAuthors(){
        List<AuthorDto> allAuthors=authorService.getAllAuthor();
        return allAuthors;
    }

    @PutMapping(path="/update")
    public String updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto){
        String authorName=authorService.updateAuthor(authorUpdateDto);
         return authorName;
    }
    @DeleteMapping(path="/delete/{id}")
    public String deleteAuthor(@PathVariable(value="id")int id){
        String authorName=authorService.deleteAuthor(id);
        return"Deleted Successfully";
    }
}
