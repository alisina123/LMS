package com.example.back.repository;

import com.example.back.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b from Book b where b.id = :id")
    Book findBookById(@Param("id") int id);
}