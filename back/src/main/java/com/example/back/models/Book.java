package com.example.back.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Library;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String registerNumber;
    private String author;
    private String translator;
    private String publisher;
    private String bookCover;
    private String bookVersion;
    @ManyToOne()
    private Library library;
    @ManyToOne()
    private BookCategory category;


}
