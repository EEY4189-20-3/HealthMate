package com.invaders.healthMate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.invaders.healthMate.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

