package com.example.back.repository;

import com.example.back.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library ,Integer> {
    @Query("SELECT l from Library l where l.id = :id")
    Library findLibraryById(@Param("id") int id);
}
