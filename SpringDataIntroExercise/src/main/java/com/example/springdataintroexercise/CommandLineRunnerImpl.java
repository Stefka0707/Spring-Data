package com.example.springdataintroexercise;

import com.example.springdataintroexercise.model.entity.Book;
import com.example.springdataintroexercise.service.AuthorService;
import com.example.springdataintroexercise.service.BookService;
import com.example.springdataintroexercise.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {


    private final CategoryService categoryService;
    private final AuthorService authorService;

    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {
             seedData();

          //   printAllBooksAfter2000(2000);
       // printAllAuthorsNamesWithBookWithReleaseDateBeforeYear(1990);
       // printAllAuthorsAndNumberOfTheirBooks();
        printAllBooksByAuthorNameOrderedByReleaseDate("George","Powell");

        System.out.println("Marta");
    }

    private void printAllBooksByAuthorNameOrderedByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderedByReleaseDate(firstName,lastName);

    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService.getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBookWithReleaseDateBeforeYear(int year) {
        bookService.findAllBAuthorsWithBooksWithReleaseDataBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfter2000(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);

    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
