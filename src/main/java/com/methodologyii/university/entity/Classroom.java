package com.methodologyii.university.entity;

import java.util.HashSet;
import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQueries({
    @NamedQuery(name = "Classroom.findAll", query = "SELECT c FROM Classroom c"),
    @NamedQuery(name = "Classroom.findByName", query = "SELECT c FROM Classroom c WHERE c.name = :name"),
    @NamedQuery(name = "Classroom.findByBuilding", query = "SELECT c FROM Classroom c WHERE c.building = :building"),
    @NamedQuery(name = "Classroom.findByCapacity", query = "SELECT c FROM Classroom c WHERE c.capacity >= :capacity")
})
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String building;

    private Integer capacity;

    @OneToMany(mappedBy = "classroom")
    private Set<Schedule> schedules = new HashSet<>();

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}