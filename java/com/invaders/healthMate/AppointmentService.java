package com.invaders.healthMate;

import com.invaders.healthMate.dto.AppointmentDto;
import com.invaders.healthMate.model.Appointment;
import com.invaders.healthMate.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.from}") // Inject the 'from' email address from application.properties
    private String fromEmail;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, JavaMailSender javaMailSender) {
        this.appointmentRepository = appointmentRepository;
        this.javaMailSender = javaMailSender;
    }

    public void bookAppointment(Appointment appointment) {
        // Perform validation checks here if needed
        appointment.setPatientName(appointment.getPatientName());
        appointment.setPhoneNumber(appointment.getPhoneNumber());
        appointment.setAddress(appointment.getAddress());
        appointment.setEmail(appointment.getEmail());
        appointment.setLocation(appointment.getLocation());
        appointment.setAppointmentDate(appointment.getAppointmentDate());
        appointment.setAppointmentTime(appointment.getAppointmentTime());

        appointmentRepository.save(appointment);

        // Send confirmation email
        sendConfirmationEmail(appointment);
    }

    private void sendConfirmationEmail(Appointment appointment) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(appointment.getEmail());
        mailMessage.setSubject("Appointment Confirmation");
        mailMessage.setText("Dear " + appointment.getPatientName() +
                ",\n\nYour appointment on " + appointment.getAppointmentDate() +
                " at " + appointment.getAppointmentTime() + " has been successfully booked.\n\nRegards,\nHealthMate Team");
        mailMessage.setFrom(fromEmail);

        javaMailSender.send(mailMessage);
    }
}
