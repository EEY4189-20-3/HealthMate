package com.invaders.healthMate.repository;

import com.invaders.healthMate.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Appointment, Long> {
}
