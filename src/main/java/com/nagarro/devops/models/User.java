package com.nagarro.devops.models;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String name;
    private String gender;
    private String country;
    private String email;
    private String pincode;
    private String dob;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", pincode='" + pincode + '\'' +
                ", dob='" + dob + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    public User(String name, String gender, String country, String email, String pincode, String dob, String phone) {
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.email = email;
        this.pincode = pincode;
        this.dob = dob;
        this.phone = phone;
    }
}
