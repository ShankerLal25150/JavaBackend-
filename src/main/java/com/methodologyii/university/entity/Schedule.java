package com.methodologyii.university.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByCourse", query = "SELECT s FROM Schedule s WHERE s.course.id = :courseId"),
    @NamedQuery(name = "Schedule.findByClassroom", query = "SELECT s FROM Schedule s WHERE s.classroom.id = :classroomId"),
    @NamedQuery(name = "Schedule.findByDate", query = "SELECT s FROM Schedule s WHERE s.startTime BETWEEN :startDate AND :endDate")
})
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startTime;

    private Date endTime;
    
    private String scheduleName;
    
    @Temporal(TemporalType.DATE)
    private Date scheduleDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public Date getScheduleDate() {
        return scheduleDate;
    }
    
    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
