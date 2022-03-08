package com.example.back.repository;

import com.example.back.models.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
    @Query("SELECT l from LibraryCard l where l.id = :id")
    LibraryCard findLibraryCardById(@Param("id") int id);
}
