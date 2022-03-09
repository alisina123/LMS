package com.example.back.repository;

import com.example.back.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission ,Integer> {
    @Query("SELECT u from Permission u where u.id = :id")
    Permission findPermissionById(@Param("id") int id);
}
