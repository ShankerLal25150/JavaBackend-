package com.methodologyii.university.controller;

import com.methodologyii.university.entity.Teacher;
import com.methodologyii.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // Create a new teacher
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    // Get all teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }

    // Get teacher by ID
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    // Update a teacher by ID
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.update(id, teacher);
    }

    // Delete a teacher by ID
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.delete(id);
    }
}
