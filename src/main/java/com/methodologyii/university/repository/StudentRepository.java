package com.methodologyii.university.repository;

import com.methodologyii.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}