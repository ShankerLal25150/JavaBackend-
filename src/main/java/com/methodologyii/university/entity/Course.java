package com.methodologyii.university.entity;

import java.util.HashSet;
import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Course.findByCourseCode", query = "SELECT c FROM Course c WHERE c.courseCode = :courseCode"),
    @NamedQuery(name = "Course.findByDepartment", query = "SELECT c FROM Course c WHERE c.department = :department"),
    @NamedQuery(name = "Course.findByTeacher", query = "SELECT c FROM Course c WHERE c.teacher.id = :teacherId")
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String courseCode;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<Schedule> schedules = new HashSet<>();

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}
