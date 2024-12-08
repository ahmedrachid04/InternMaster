package com.example.internmaster.Student;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.Arrays;

@Entity
@Table(name = "student")
public class StudentModel {
    @Id
    @SequenceGenerator(
            initialValue = 1,
            name = "id",
            sequenceName = "id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id"
    )
    private long id;
    @Column(length = 200, nullable = false)
    private String firstName;
    @Column(length = 200, nullable = false)
    private String lastName;
    @Column(length = 200, nullable = false)
    private String email;
    @Column(length = 13, nullable = false)
    private String phoneNumber;
    @Column(length = 300)
    private String specialty;
    @Lob
    private byte[] profilePicture;
    @Column(length = 200, nullable = false)
    private String school;
    @Column(length = 200, nullable = false)
    private String password;

    public StudentModel(String firstName, String lastName, String email, String phoneNumber, String specialty, byte[] profilePicture, String school, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
        this.profilePicture = profilePicture;
        this.school = school;
        this.password = password;
    }

    public StudentModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", specialty='" + specialty + '\'' +
                ", profilePicture= binary data" +'\'' +
                ", school='" + school + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
