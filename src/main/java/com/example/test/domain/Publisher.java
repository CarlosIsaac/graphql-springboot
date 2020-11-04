package com.example.test.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "publisher")
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();
}
