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

        appointment.setPatientName(appointment.getPatientName());
        appointment.setPhoneNumber(appointment.getPhoneNumber());
        appointment.setAddress(appointment.getAddress());
        appointment.setEmail(appointment.getEmail());
        appointment.setLocation(appointment.getLocation());
        appointment.setAppointmentDate(appointment.getAppointmentDate());
        appointment.setAppointmentTime(appointment.getAppointmentTime());

        appointmentRepository.save(appointment);
    }

    private void validateAppointmentDto(AppointmentDto appointmentDto) {

        // validation for non-empty fields
        if (appointmentDto.getPatientName() == null || appointmentDto.getPatientName().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty");
        }

        if (appointmentDto.getEmail() == null || appointmentDto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        // Add more validation as needed...
    }
}
