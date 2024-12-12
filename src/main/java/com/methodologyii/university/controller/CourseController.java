package com.methodologyii.university.controller;

import com.methodologyii.university.entity.Course;
import com.methodologyii.university.entity.Schedule;
import com.methodologyii.university.service.CourseService;
import com.methodologyii.university.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private ScheduleService scheduleService;

    // Create a new course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    // Get all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    // Get course by ID
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    // Update a course by ID
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.update(id, course);
    }

    // Delete a course by ID
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
    }
    @GetMapping("/{courseId}/schedules")
    public List<Schedule> getSchedulesForCourse(@PathVariable Long courseId) {
    return scheduleService.getSchedulesByCourse(courseId);
    }
    
    @GetMapping("/findByTeacher")
    public List<Course> getCoursesByTeacher(@RequestParam Long teacherId) {
    return courseService.getCoursesByTeacher(teacherId);
}


}