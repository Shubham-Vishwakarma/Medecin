package com.medecin.model;

import javax.persistence.*;
import java.util.Locale;

@Table(name = "patient")
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "patient_generator")
    @TableGenerator(name = "patient_generator", table = "patient_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "contact", nullable = false)
    private String contact;

    public Patient() {}

    public Patient(String firstName, String lastName, String gender, int age, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender.toUpperCase(Locale.ROOT);
        this.age = age;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contactNumber) {
        this.contact = contactNumber;
    }

}
