package com.ebcs.library.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {
    @GetMapping("/create")
    public String createBook(Model model)
    {
        return "create-book";
    }
    @GetMapping("/edit")
    public String editBook()
    {
        return "edit-book";
    }
    @GetMapping("/list")
    public String listBooks()
    {
        return "list-books";
    }
    @PostMapping("/save")
    public String saveBook()
    {
        return "save-book";
    }


}
