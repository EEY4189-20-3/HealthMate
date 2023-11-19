package com.invaders.healthMate;

import com.invaders.healthMate.model.Appointment;
import com.invaders.healthMate.repository.AppointmentRepository;
import com.invaders.healthMate.repository.DoctorRepository;
import com.invaders.healthMate.repository.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final LocationRepository locationRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentController(AppointmentRepository appointmentRepository,
                                 LocationRepository locationRepository,
                                 DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.locationRepository = locationRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/book")
    public String showBookingForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "bookForm";
    }

    @PostMapping("/book")
    public String bookAppointment(@ModelAttribute("appointment") @Valid Appointment appointment,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bookForm";
        }

        // Save the appointment to the database
        appointmentRepository.save(appointment);

        // You can redirect to the next step, such as selecting a location
        return "redirect:/Location";
    }

    // Add more methods for handling location selection, doctor selection, etc.
}

