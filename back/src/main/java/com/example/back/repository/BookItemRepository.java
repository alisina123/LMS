package com.example.back.repository;

import com.example.back.models.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Integer> {
    @Query("SELECT b from BookItem b where b.id = :id")
    BookItem findBookItemById(@Param("id") int id);
}
