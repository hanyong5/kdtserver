package com.ganseo.ganseo.jpa;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String bookname;
    private String author;
    private String publisher;

    private Integer year;
    private String cate;
    private String keywords;
}
