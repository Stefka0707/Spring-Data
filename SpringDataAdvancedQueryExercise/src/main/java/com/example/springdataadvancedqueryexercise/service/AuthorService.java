package com.example.springdataadvancedqueryexercise.service;

import com.example.springdataadvancedqueryexercise.models.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService  {


    void seedAuthors() throws IOException;

    Author getRandomAuthor();


    List<String> findAuthorsWithFirstName(String endsWith);


    List<String>  findTotalBookCopies();
}
