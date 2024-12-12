package com.methodologyii.university.controller;

import com.methodologyii.university.entity.Staff;
import com.methodologyii.university.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    // Create a new staff member
    @PostMapping
    public Staff createStaff(@RequestBody Staff staff) {
        return staffService.save(staff);
    }

    // Get all staff members
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.findAll();
    }

    // Get staff member by ID
    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return staffService.findById(id);
    }

    // Update a staff member by ID
    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        return staffService.update(id, staff);
    }

    // Delete a staff member by ID
    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.delete(id);
    }
}
