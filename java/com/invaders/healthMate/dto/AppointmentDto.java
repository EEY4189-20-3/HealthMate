package com.invaders.healthMate.dto;

public class AppointmentDto {
    private String patientName;
    private String phoneNumber;
    private String address;
    private String email;

    // Getters and setters
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
