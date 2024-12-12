package com.methodologyii.university.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByDepartment", query = "SELECT t FROM Teacher t WHERE t.department.id = :departmentId"),
    @NamedQuery(name = "Teacher.findByName", query = "SELECT t FROM Teacher t WHERE t.name = :name")
})
public class Teacher {

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