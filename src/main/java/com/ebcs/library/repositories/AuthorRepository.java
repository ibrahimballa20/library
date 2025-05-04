package com.ebcs.library.repositories;

import com.ebcs.library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
