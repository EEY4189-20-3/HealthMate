package com.invaders.healthMate;

import com.invaders.healthMate.dto.AppointmentDto;
import com.invaders.healthMate.dto.RegistrationDto;
import com.invaders.healthMate.model.Appointment;
import com.invaders.healthMate.model.User;
import com.invaders.healthMate.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public void processAppointment(AppointmentDto appointmentDto) {
        validateAppointmentDto(appointmentDto);

        Appointment appointment = new Appointment();
        appointment.setPatientName(appointmentDto.getPatientName());
        appointment.setPhoneNumber(appointmentDto.getPhoneNumber());
        appointment.setAddress(appointmentDto.getAddress());
        appointment.setEmail(appointmentDto.getEmail());

        appointmentRepository.save(appointment);
    }

    private void validateAppointmentDto(AppointmentDto appointmentDto) {
        // Add validation logic here (e.g., check for empty fields, valid email format, etc.)
        // You can use Spring's validation annotations in the RegistrationDto class or custom logic.

        // Example validation for non-empty fields
        if (appointmentDto.getPatientName() == null || appointmentDto.getPatientName().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty");
        }

        if (appointmentDto.getEmail() == null || appointmentDto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        // Add more validation as needed...
    }
}
