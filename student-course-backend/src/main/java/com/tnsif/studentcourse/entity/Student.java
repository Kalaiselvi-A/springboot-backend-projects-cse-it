package com.tnsif.studentcourse.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;
    private String year;
    private String phone;
    private String address;
    private LocalDate dob;
    private String gender;

    // ----- Constructors -----

    public Student() {}

    public Student(Long id, String name, String email, String department, String year,
                   String phone, String address, LocalDate dob, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.year = year;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }

    // ----- Getters & Setters -----

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

}
