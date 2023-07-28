package com.example.springdataadvancedqueryexercise.service;

import com.example.springdataadvancedqueryexercise.models.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
