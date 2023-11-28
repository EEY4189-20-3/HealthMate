package com.invaders.healthMate;

import com.invaders.healthMate.dto.AppointmentDto;
import com.invaders.healthMate.dto.RegistrationDto;
import com.invaders.healthMate.model.Appointment;
import com.invaders.healthMate.repository.AppointmentRepository;
import com.invaders.healthMate.repository.DoctorRepository;
import com.invaders.healthMate.repository.LocationRepository;
import com.invaders.healthMate.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentService appointmentService;
    private final LocationRepository locationRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentController(AppointmentRepository appointmentRepository,
                                 AppointmentService appointmentService,
                                 LocationRepository locationRepository,
                                 DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentService = appointmentService;
        this.locationRepository = locationRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/book")
    public String showBookingForm(Model model) {
        model.addAttribute("appointmentDto", new AppointmentDto());
        return "bookForm";
    }

    @PostMapping("/book")
    public ResponseEntity<Map<String, Object>> bookAppointment(@RequestBody Appointment appointment) {
        try {
            // Logic for booking the appointment
            appointmentService.bookAppointment(appointment);

            // Construct the success response
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Appointment booked successfully!");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();

            // Construct the error response
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("error", "Failed to book the appointment. Please try again.");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
