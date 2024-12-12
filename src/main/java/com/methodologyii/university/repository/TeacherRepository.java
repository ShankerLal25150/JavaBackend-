package com.methodologyii.university.repository;

import com.methodologyii.university.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}