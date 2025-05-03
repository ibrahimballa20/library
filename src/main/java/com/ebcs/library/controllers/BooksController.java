package com.ebcs.library.controllers;


import com.ebcs.library.entities.Author;
import com.ebcs.library.entities.Book;
import com.ebcs.library.services.AuthorService;
import com.ebcs.library.services.BookService;
import com.ebcs.library.services.CategoryService;
import jakarta.validation.Valid;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


@Controller
@RequestMapping("/books")
public class BooksController {

    private final CategoryService categoryService;
    private final BookService bookService;
    private final AuthorService authorService;
    @Autowired
    public BooksController(CategoryService categoryService, BookService bookService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }
    @GetMapping("/")
    public String booksPage(Model model)
    {
        model.addAttribute("books",this.bookService.findAll());
        return "view-books";
    }
    @GetMapping("/create")
    public String createBook(Model model)
    {
        model.addAttribute("categories",this.categoryService.findAll());
        model.addAttribute("authors",this.authorService.findAll());
        model.addAttribute("book", new Book());

        return "create-book";
    }
    @PostMapping("/create")
    public String saveBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult bindingResult,
            @RequestParam("authorIds") List<Long> authorIds,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("authors", authorService.findAll());
            return "create-book";
        }
        List<Author> selectedAuthors = authorService.getAuthorsByIds(authorIds);
        book.setAuthors(new HashSet<>(selectedAuthors));

        bookService.createBook(book);
        return "redirect:/books/";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model)
    {
        Book book = bookService.findByIdWithAuthors(id);
        List<Author> selectedAuthors = new ArrayList<>(book.getAuthors());
        List<Author> allAuthors = authorService.findAll();
        model.addAttribute("book", book);
        model.addAttribute("selectedAuthors", selectedAuthors);
        model.addAttribute("authors", allAuthors);
        model.addAttribute("categories", categoryService.findAll());
        return "edit-book";
    }
    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book, @RequestParam("authorIds") List<Long> authorIds) {

        List<Author> authorsList = this.authorService.getAuthorsByIds(authorIds);
        Book existingBook = this.bookService.getBookById(book.getId());
        existingBook.setTitle(book.getTitle());
        existingBook.setCode(book.getCode());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setCategory(book.getCategory());
        existingBook.setPublicationDate(book.getPublicationDate());
        this.bookService.deleteAuthors(existingBook.getId());
        existingBook.setAuthors(new HashSet<>(authorsList));
        this.bookService.updateBook(existingBook);
        return "redirect:/books/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {

        bookService.deleteAuthors(id);
        bookService.deleteBookById(id);
        return "redirect:/books/";
    }


}
