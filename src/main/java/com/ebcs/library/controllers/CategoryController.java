package com.ebcs.library.controllers;


import com.ebcs.library.entities.Book;
import com.ebcs.library.entities.Category;
import com.ebcs.library.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/create")
    public String addCategory() {
        return "create-category";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id,Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category",category);
        return "edit-category";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/category/index";
    }
    @PostMapping("/update")
    public String updateCategory(@ModelAttribute("category")Category category) {

        this.categoryService.updateCategory(category);
        return "redirect:/category/index";
    }
    @PostMapping("/create")
    public String saveCategory(@Valid @ModelAttribute("book")Category category) {
        this.categoryService.saveCategory(category);
        return "redirect:/category/index";
    }
    @GetMapping("/index")
    public String categoriesPage(Model model) {
        model.addAttribute("categories",this.categoryService.findAll());
        return "view-categories";
    }

}
