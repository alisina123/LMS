package com.example.back.repository;

import com.example.back.models.LibraryMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryMemberRepository extends JpaRepository<LibraryMember, Integer> {
    @Query("SELECT l from LibraryMember l where l.id = :id")
    LibraryMember findLibraryMemberById(@Param("id") int id);
}
