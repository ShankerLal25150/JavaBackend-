package com.methodologyii.university.controller;

import com.methodologyii.university.entity.Schedule;
import com.methodologyii.university.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    // Get all schedules
    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    // Get schedules by course ID
    @GetMapping("/course/{courseId}")
    public List<Schedule> getSchedulesByCourse(@PathVariable Long courseId) {
        return scheduleService.getSchedulesByCourse(courseId);
    }

    // Get schedules by teacher ID
    @GetMapping("/teacher/{teacherId}")
    public List<Schedule> getSchedulesByTeacher(@PathVariable Long teacherId) {
        return scheduleService.getSchedulesByTeacher(teacherId);
    }

    // Get schedules by classroom ID
    @GetMapping("/classroom/{classroomId}")
    public List<Schedule> getSchedulesByClassroom(@PathVariable Long classroomId) {
        return scheduleService.getSchedulesByClassroom(classroomId);
    }

    // Get schedules by date
    @GetMapping("/date/{scheduleDate}")
    public List<Schedule> getSchedulesByDate(@PathVariable java.util.Date scheduleDate) {
        return scheduleService.getSchedulesByDate(scheduleDate);
    }

    // Get a specific schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update schedule
    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.saveSchedule(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSchedule);
    }

    // Delete schedule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}