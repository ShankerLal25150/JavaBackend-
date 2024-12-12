package com.methodologyii.university.repository;

import com.methodologyii.university.entity.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(name = "Course.findByTeacher")
    List<Course> findByTeacherId(Long teacherId);
}
