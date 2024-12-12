package com.methodologyii.university.service;

import com.methodologyii.university.entity.Teacher;
import com.methodologyii.university.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    // Save a new teacher
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Get all teachers
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    // Find a teacher by ID
    public Teacher findById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null);  // Return null if not found
    }

    // Update a teacher by ID
    public Teacher update(Long id, Teacher teacher) {
        if (teacherRepository.existsById(id)) {
            teacher.setId(id);  // Ensure we're updating the right teacher
            return teacherRepository.save(teacher);
        }
        return null;  // Return null if teacher doesn't exist
    }

    // Delete a teacher by ID
    public void delete(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
        }
    }
}