package com.example.test.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private List<Book> books;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private List<Author> authors;
}
