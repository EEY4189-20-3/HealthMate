package com.invaders.healthMate;

import com.invaders.healthMate.model.User;
import com.invaders.healthMate.dto.RegistrationDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Login")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // This endpoint handles the submission of both Step One and Step Two forms
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("registrationDto") RegistrationDto registrationDto,
                               BindingResult bindingResult, Model model) {
        // Validate the data
        if (bindingResult.hasErrors()) {
            // If there are validation errors, return to the registration form with error messages
            return "redirect:/Login";  // Change this to your actual form name
        }

        // Process and store the user registration data
        registrationService.processUserRegistration(registrationDto);

        // redirect to a success page or do other post-registration actions
        return "redirect:/login?success"; // Change "/login/success" to your actual success page
    }
}


