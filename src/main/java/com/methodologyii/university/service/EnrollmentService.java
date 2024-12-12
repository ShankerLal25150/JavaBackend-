package com.methodologyii.university.service;

import com.methodologyii.university.entity.Enrollment;
import com.methodologyii.university.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Get enrollments by student
    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    // Get enrollments by course
    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    // Get enrollments by status
    public List<Enrollment> getEnrollmentsByStatus(String status) {
        return enrollmentRepository.findByStatus(status);
    }

    // Get enrollments by date
    public List<Enrollment> getEnrollmentsByDate(java.util.Date enrollmentDate) {
        return enrollmentRepository.findByEnrollmentDate(enrollmentDate);
    }

    // Get a specific enrollment by ID
    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    // Create or update an enrollment
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    // Delete an enrollment
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}