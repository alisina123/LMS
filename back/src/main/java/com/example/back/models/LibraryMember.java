package com.example.back.models;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String guarantee;
    @Nullable
    private Date jointYear ;
    private String job;
    @ManyToOne
    private Library library;

}
