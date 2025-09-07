package com.college.cms.repository;

import com.college.cms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<Student> findByUser_Username(String username);
}

