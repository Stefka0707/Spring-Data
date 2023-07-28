package com.example.springdataintroexercise.service;

import com.example.springdataintroexercise.model.entity.Book;

import java.io.IOException;
import java.util.List;


public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllBAuthorsWithBooksWithReleaseDataBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderedByReleaseDate(String firstName,String lastName);

}
