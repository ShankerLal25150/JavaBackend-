package com.methodologyii.university.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByDepartment", query = "SELECT s FROM Student s WHERE s.department.id = :departmentId"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}