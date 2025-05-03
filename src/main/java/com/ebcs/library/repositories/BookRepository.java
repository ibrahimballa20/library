package com.ebcs.library.repositories;

import com.ebcs.library.entities.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository  extends JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = {"authors"})
    Optional<Book> findById(Long id);
}
