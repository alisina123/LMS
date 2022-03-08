package com.example.back.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Library;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LibraryMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String LastName;
    private String fatherName;
    private String registerNumber;
    private String degree;
    private String province;
    private String phone;
    private String currentAddress;
    private String identityNumber;
    private String photo;
    private String guarantee;
    private Date jointYear;
    private String job;
    @ManyToOne
    private Library library;

}
