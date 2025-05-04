package com.ebcs.library.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String biography;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deathDate;
    private String email;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();


}
