package com.methodologyii.university.service;

import com.methodologyii.university.entity.Course;
import com.methodologyii.university.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Save a new course
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
    
    public List<Course> getCoursesByTeacher(Long teacherId) {
    return courseRepository.findByTeacherId(teacherId);
}

    // Find a course by ID
    public Course findById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);  // Return null if not found
    }

    // Update a course by ID
    public Course update(Long id, Course course) {
        if (courseRepository.existsById(id)) {
            course.setId(id);  // Ensure we're updating the right course
            return courseRepository.save(course);
        }
        return null;  // Return null if course doesn't exist
    }

    // Delete a course by ID
    public void delete(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }
    }
}