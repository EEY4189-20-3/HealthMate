package com.invaders.healthMate;

import com.invaders.healthMate.dto.RegistrationDto;
import com.invaders.healthMate.model.User;
import com.invaders.healthMate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;

    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void processUserRegistration(RegistrationDto registrationDto) {
        validateRegistrationDto(registrationDto);

        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setType(registrationDto.getType());
        user.setServiceType(registrationDto.getServiceType());
        user.setLocation(registrationDto.getLocation());
        user.setPassword(registrationDto.getPassword());
        user.setConfirmPassword(registrationDto.getPassword());

        userRepository.save(user);
    }

    private void validateRegistrationDto(RegistrationDto registrationDto) {
        // Add validation logic here (e.g., check for empty fields, valid email format, etc.)
        // You can use Spring's validation annotations in the RegistrationDto class or custom logic.

        // Example validation for non-empty fields
        if (registrationDto.getUsername() == null || registrationDto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (registrationDto.getEmail() == null || registrationDto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        // Add more validation as needed...
    }

    // Other methods...
}


