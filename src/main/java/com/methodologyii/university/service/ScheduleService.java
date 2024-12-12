package com.methodologyii.university.service;

import com.methodologyii.university.entity.Schedule;
import com.methodologyii.university.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // Get all schedules
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // Get schedules by course ID
    public List<Schedule> getSchedulesByCourse(Long courseId) {
        return scheduleRepository.findByCourseId(courseId);
    }

    // Get schedules by teacher ID
    public List<Schedule> getSchedulesByTeacher(Long teacherId) {
        return scheduleRepository.findByTeacherId(teacherId);
    }

    // Get schedules by classroom ID
    public List<Schedule> getSchedulesByClassroom(Long classroomId) {
        return scheduleRepository.findByClassroomId(classroomId);
    }

    // Get schedules by date
    public List<Schedule> getSchedulesByDate(java.util.Date scheduleDate) {
        return scheduleRepository.findByScheduleDate(scheduleDate);
    }

    // Get schedule by ID
    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    // Create or update schedule
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Delete schedule
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}