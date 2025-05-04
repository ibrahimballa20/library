package com.ebcs.library.services;


import com.ebcs.library.entities.Category;
import com.ebcs.library.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;

    @Test
    void testGetCategoryById() {
        Category mockCategory = new Category();
        mockCategory.setId(1L);
        mockCategory.setName("Mock Name");

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(mockCategory));

        Category result = categoryService.getCategoryById(1L);

        assertNotNull(result);
        assertEquals("Mock Name", result.getName());
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveCategory() {
        Category category = new Category();
        category.setName("New Category");
        when(categoryRepository.save(category)).thenReturn(category);
        Category saved = categoryService.saveCategory(category);
        assertNotNull(saved);
        assertEquals("New Category", saved.getName());
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testDeleteCategoryById() {
        Long id = 2L;
        categoryService.deleteCategoryById(id);
        verify(categoryRepository, times(1)).deleteById(id);
    }

}
