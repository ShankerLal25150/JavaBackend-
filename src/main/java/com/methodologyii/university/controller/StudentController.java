package com.methodologyii.university.controller;

import com.methodologyii.university.entity.Student;
import com.methodologyii.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    // Update a student by ID
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }
}
