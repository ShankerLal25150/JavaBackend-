package com.methodologyii.university.service;

import com.methodologyii.university.entity.Student;
import com.methodologyii.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Save a new student
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Find a student by ID
    public Student findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);  // Return null if not found
    }

    // Update a student by ID
    public Student update(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);  // Ensure we're updating the right student
            return studentRepository.save(student);
        }
        return null;  // Return null if student doesn't exist
    }

    // Delete a student by ID
    public void delete(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
    }
}