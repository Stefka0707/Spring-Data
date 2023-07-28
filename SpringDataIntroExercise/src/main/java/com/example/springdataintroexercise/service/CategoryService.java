package com.example.springdataintroexercise.service;

import com.example.springdataintroexercise.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
