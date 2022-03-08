package com.example.back.repository;

import com.example.back.models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
    @Query("SELECT b from BookCategory b where b.id = :id")
    BookCategory findBookCategoryById(@Param("id") int id);
}
