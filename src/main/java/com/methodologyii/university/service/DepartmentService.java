package com.methodologyii.university.service;

import com.methodologyii.university.entity.Department;
import com.methodologyii.university.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Save a new department
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    // Get all departments
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    // Find department by ID
    public Department findById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null);  // Return null if not found
    }

    // Update a department by ID
    public Department update(Long id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setId(id);  // Ensure we're updating the right department
            return departmentRepository.save(department);
        }
        return null;  // Return null if department doesn't exist
    }

    // Delete a department by ID
    public void delete(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        }
    }
}