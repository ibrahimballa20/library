package com.ebcs.library.controllers;

import com.ebcs.library.entities.Author;
import com.ebcs.library.entities.Book;
import com.ebcs.library.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/index")
    public String authorsPage(Model model) {
        model.addAttribute("authors",this.authorService.findAll());
        return "view-authors";
    }
    @GetMapping("/create")
    public String addAuthor() {
        return "create-author";
    }
    @GetMapping("/edit/{id}")
    public String editAuthor(@PathVariable("id") Long id,Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author",author);
        return "edit-author";
    }
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        this.authorService.deleteAuthorById(id);
        return "redirect:/author/index";
    }
    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute("author") Author author) {
        this.authorService.updateAuthor(author);
        return "redirect:/author/index";
    }
    @PostMapping("/create")
    public String saveAuthor(@Valid @ModelAttribute("author") Author author) {
        this.authorService.saveAuthor(author);
        return "redirect:/author/index";
    }


}
