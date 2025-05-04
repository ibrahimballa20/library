package com.ebcs.library.services;

import com.ebcs.library.entities.Author;
import com.ebcs.library.entities.Category;
import com.ebcs.library.repositories.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private AuthorService authorService;

    @Test
    void testGetAuthorById() {
        Author mockAuthor = new Author();
        mockAuthor.setId(1L);
        mockAuthor.setFirstname("Mock Firstname");

        when(authorRepository.findById(1L)).thenReturn(Optional.of(mockAuthor));

        Author result = authorService.getAuthorById(1L);

        assertNotNull(result);
        assertEquals("Mock Firstname", result.getFirstname());
        verify(authorRepository, times(1)).findById(1L);
    }
    @Test
    void testSaveAuthor() {
        Author author = new Author();
        author.setFirstname("New Author");
        when(authorRepository.save(author)).thenReturn(author);
        Author saved = authorService.saveAuthor(author);
        assertNotNull(saved);
        assertEquals("New Author", saved.getFirstname());
        verify(authorRepository, times(1)).save(author);
    }

}
