package com.example.back.repository;

import com.example.back.models.BookLending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLendingRepository extends JpaRepository<BookLending, Long> {
}
