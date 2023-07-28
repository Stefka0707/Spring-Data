package com.example.springdataintroexercise.service.impl;

import com.example.springdataintroexercise.model.entity.Category;
import com.example.springdataintroexercise.repository.CategoryRepository;
import com.example.springdataintroexercise.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_PATH = "src/main/resources/files/categories.txt";

    public final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }
        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(categoryName -> {
                    Category category = new Category(categoryName);

                    categoryRepository.save(category);

                });
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();

        int randInt = ThreadLocalRandom
                .current().nextInt(1, 3);

        Long catRepoCount = categoryRepository.count();

        for (int i = 0; i < randInt; i++) {
            Long randomId = ThreadLocalRandom
                    .current()
                    .nextLong(1, catRepoCount + 1);

            Category category = categoryRepository
                    .findById(randomId)
                    .orElse(null);

            categories.add(category);
        }
        return categories;
    }
}
