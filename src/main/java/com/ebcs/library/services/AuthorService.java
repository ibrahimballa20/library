package com.ebcs.library.services;


import com.ebcs.library.entities.Author;
import com.ebcs.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    public List<Author> getAuthorsByIds(List<Long> authorIds) {
        return authorRepository.findAllById(authorIds);
    }
}
