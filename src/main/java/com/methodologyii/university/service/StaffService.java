package com.methodologyii.university.service;

import com.methodologyii.university.entity.Staff;
import com.methodologyii.university.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    // Save a new staff member
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    // Get all staff members
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    // Find a staff member by ID
    public Staff findById(Long id) {
        Optional<Staff> staff = staffRepository.findById(id);
        return staff.orElse(null);  // Return null if not found
    }

    // Update a staff member by ID
    public Staff update(Long id, Staff staff) {
        if (staffRepository.existsById(id)) {
            staff.setId(id);  // Ensure we're updating the right staff member
            return staffRepository.save(staff);
        }
        return null;  // Return null if staff doesn't exist
    }

    // Delete a staff member by ID
    public void delete(Long id) {
        if (staffRepository.existsById(id)) {
            staffRepository.deleteById(id);
        }
    }
}