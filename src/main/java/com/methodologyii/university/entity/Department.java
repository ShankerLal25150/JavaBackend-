package com.methodologyii.university.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByBuilding", query = "SELECT d FROM Department d WHERE d.building = :building"),
    @NamedQuery(name = "Department.findByTeacher", query = "SELECT d FROM Department d JOIN d.teachers t WHERE t.id = :teacherId"),
    @NamedQuery(name = "Department.findByStudent", query = "SELECT d FROM Department d JOIN d.students s WHERE s.id = :studentId")
})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String building;

    @OneToMany(mappedBy = "department")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Teacher> teachers = new HashSet<>();

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}