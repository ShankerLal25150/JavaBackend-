package com.methodologyii.university.repository;

import com.methodologyii.university.entity.Course;
import com.methodologyii.university.entity.Enrollment;
import com.methodologyii.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudentId(Long studentId);
    
    List<Enrollment> findByStudent(Student student);
    
    List<Enrollment> findByCourse(Course course);

    List<Enrollment> findByCourseId(Long courseId);

    List<Enrollment> findByStatus(String status);

    List<Enrollment> findByEnrollmentDate(java.util.Date enrollmentDate);
}