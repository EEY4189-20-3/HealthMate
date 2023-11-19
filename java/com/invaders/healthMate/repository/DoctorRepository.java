package com.invaders.healthMate.repository;

import com.invaders.healthMate.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByLocation(String location);
}
