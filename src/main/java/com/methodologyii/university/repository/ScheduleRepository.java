package com.methodologyii.university.repository;

import com.methodologyii.university.entity.Schedule;
import com.methodologyii.university.entity.Teacher;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByCourseId(Long courseId);

    List<Schedule> findByTeacher(Teacher teacher);
    
    List<Schedule> findByTeacherId(Long teacherId);

    List<Schedule> findByClassroomId(Long classroomId);
    
    @Query("SELECT s FROM Schedule s WHERE s.scheduleDate = :scheduleDate")
    List<Schedule> findByScheduleDate(@Param("scheduleDate") Date scheduleDate);
}