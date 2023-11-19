// DoctorService.java
package com.invaders.healthMate;

import com.invaders.healthMate.model.Doctor;
import com.invaders.healthMate.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctorsByLocation(String location) {
        return doctorRepository.findByLocation(location);
    }
}
