package com.methodologyii.university.repository;

import com.methodologyii.university.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    @PersistenceContext
    EntityManager entityManager = null;

    default List<Classroom> findByDepartment(Long departmentId) {
        TypedQuery<Classroom> query = entityManager.createNamedQuery("Classroom.findByDepartment", Classroom.class);
        query.setParameter("departmentId", departmentId);
        return query.getResultList();
    }

    default List<Classroom> findByRoomNumber(String roomNumber) {
        TypedQuery<Classroom> query = entityManager.createNamedQuery("Classroom.findByRoomNumber", Classroom.class);
        query.setParameter("roomNumber", roomNumber);
        return query.getResultList();
    }

    default List<Classroom> findByCapacity(int capacity) {
        TypedQuery<Classroom> query = entityManager.createNamedQuery("Classroom.findByCapacity", Classroom.class);
        query.setParameter("capacity", capacity);
        return query.getResultList();
    }

    default List<Classroom> findByCourse(Long courseId) {
        TypedQuery<Classroom> query = entityManager.createNamedQuery("Classroom.findByCourse", Classroom.class);
        query.setParameter("courseId", courseId);
        return query.getResultList();
    }
}