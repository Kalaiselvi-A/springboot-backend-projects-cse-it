package com.tnsif.studentcourse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String departmentName;

    @Column(nullable = false)
    private String departmentCode;  // e.g., CSE101, IT201, ECE301

    @Column
    private String description;

    // ----------------- Constructor -----------------

    public Department() {}

    public Department(String departmentName, String departmentCode, String description) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.description = description;
    }

    // ----------------- Getters & Setters -----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
