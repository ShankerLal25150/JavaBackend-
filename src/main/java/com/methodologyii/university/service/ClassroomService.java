package com.methodologyii.university.service;

import com.methodologyii.university.entity.Classroom;
import com.methodologyii.university.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<Classroom> getClassroomsByDepartment(Long departmentId) {
        return classroomRepository.findByDepartment(departmentId);
    }

    public List<Classroom> getClassroomsByRoomNumber(String roomNumber) {
        return classroomRepository.findByRoomNumber(roomNumber);
    }

    public List<Classroom> getClassroomsByCapacity(int capacity) {
        return classroomRepository.findByCapacity(capacity);
    }

    public List<Classroom> getClassroomsByCourse(Long courseId) {
        return classroomRepository.findByCourse(courseId);
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }

    public Classroom getClassroomById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}