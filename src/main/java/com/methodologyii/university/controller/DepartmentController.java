package com.methodologyii.university.controller;

import com.methodologyii.university.entity.Department;
import com.methodologyii.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Create a new department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    // Get all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    // Get department by ID
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    // Update a department by ID
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.update(id, department);
    }

    // Delete a department by ID
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
    }
}