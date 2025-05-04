package com.ebcs.library.services;

import com.ebcs.library.entities.Book;
import com.ebcs.library.entities.BookWithAuthorCount;
import com.ebcs.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(BookRepository bookRepository, JdbcTemplate jdbcTemplate) {
        this.bookRepository = bookRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book createBook(Book book) {
        return this.bookRepository.save(book);
    }
    public void updateBook(Book book) {
        this.bookRepository.save(book);
    }
    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }

    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }
    public Book getBookById(Long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Book findByIdWithAuthors(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }
    public List<BookWithAuthorCount> getBooksAndAuthorCount()
    {
        String sql = """
                SELECT b.*, COUNT(ba.author_id) AS author_count
                FROM book b
                LEFT JOIN book_authors ba ON b.id = ba.book_id
                GROUP BY b.id, b.title
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BookWithAuthorCount result = new BookWithAuthorCount();
            result.setId(rs.getLong("id"));
            result.setTitle(rs.getString("title"));
            result.setCode(rs.getString("code"));
            result.setIsbn(rs.getString("isbn"));
            result.setPublisher(rs.getString("publisher"));
            result.setPublicationDate(rs.getDate("publication_date"));
            result.setAuthorCount(rs.getInt("author_count"));
            return result;
        });


    }

    public void deleteAuthors(Long bookid)
    {
        this.jdbcTemplate.update("DELETE FROM book_authors WHERE book_id = ?", bookid);

    }

}
