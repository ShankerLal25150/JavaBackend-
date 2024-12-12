package com.methodologyii.university.controller;

import com.methodologyii.university.entity.Enrollment;
import com.methodologyii.university.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Get all enrollments
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    // Get enrollments by student ID
    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudent(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudent(studentId);
    }

    // Get enrollments by course ID
    @GetMapping("/course/{courseId}")
    public List<Enrollment> getEnrollmentsByCourse(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourse(courseId);
    }

    // Get enrollments by status
    @GetMapping("/status/{status}")
    public List<Enrollment> getEnrollmentsByStatus(@PathVariable String status) {
        return enrollmentService.getEnrollmentsByStatus(status);
    }

    // Get enrollments by enrollment date
    @GetMapping("/date/{enrollmentDate}")
    public List<Enrollment> getEnrollmentsByDate(@PathVariable java.util.Date enrollmentDate) {
        return enrollmentService.getEnrollmentsByDate(enrollmentDate);
    }

    // Get a specific enrollment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollment> enrollment = enrollmentService.getEnrollmentById(id);
        return enrollment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update an enrollment
    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment savedEnrollment = enrollmentService.saveEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEnrollment);
    }

    // Delete an enrollment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}