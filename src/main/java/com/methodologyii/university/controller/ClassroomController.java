package com.methodologyii.university.controller;

import com.methodologyii.university.entity.Classroom;
import com.methodologyii.university.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping("/department/{departmentId}")
    public List<Classroom> getClassroomsByDepartment(@PathVariable Long departmentId) {
        return classroomService.getClassroomsByDepartment(departmentId);
    }

    @GetMapping("/room/{roomNumber}")
    public List<Classroom> getClassroomsByRoomNumber(@PathVariable String roomNumber) {
        return classroomService.getClassroomsByRoomNumber(roomNumber);
    }

    @GetMapping("/capacity/{capacity}")
    public List<Classroom> getClassroomsByCapacity(@PathVariable int capacity) {
        return classroomService.getClassroomsByCapacity(capacity);
    }

    @GetMapping("/course/{courseId}")
    public List<Classroom> getClassroomsByCourse(@PathVariable Long courseId) {
        return classroomService.getClassroomsByCourse(courseId);
    }

    @PostMapping
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classroomService.saveClassroom(classroom);
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
    }
}