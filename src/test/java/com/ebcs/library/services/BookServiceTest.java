package com.ebcs.library.services;

import com.ebcs.library.entities.Book;
import com.ebcs.library.repositories.BookRepository;
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
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testGetBookById() {
        Book mockBook = new Book();
        mockBook.setId(1L);
        mockBook.setTitle("Mock Title");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(mockBook));

        Book result = bookService.getBookById(1L);

        assertNotNull(result);
        assertEquals("Mock Title", result.getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveBook() {
        Book book = new Book();
        book.setTitle("New Book");

        when(bookRepository.save(book)).thenReturn(book);

        Book saved = bookService.createBook(book);

        assertNotNull(saved);
        assertEquals("New Book", saved.getTitle());
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testDeleteBookById() {
        Long id = 2L;

        bookService.deleteBookById(id);

        verify(bookRepository, times(1)).deleteById(id);
    }
}
