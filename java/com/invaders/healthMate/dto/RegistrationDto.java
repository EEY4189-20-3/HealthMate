package com.invaders.healthMate.dto;

public class RegistrationDto {

    private String username;
    private String email;
    private String loginType;
    private String type;
    private String password;
    private String location;
    private String serviceType;

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() { return password; }
    public String getLoginType() { return loginType; }
    public String getType() { return type; }
    public String getLocation() { return location; }
    public String getServiceType() {
        return serviceType;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
