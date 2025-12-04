package com.tnsif.hostelmanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private LocalDate joiningDate;
    private LocalDate leavingDate;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room; // Room assigned to tenant

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<RentPayment> payments; // Rent payment history

    // Constructors
    public Tenant() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }
    public LocalDate getLeavingDate() { return leavingDate; }
    public void setLeavingDate(LocalDate leavingDate) { this.leavingDate = leavingDate; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
    public List<RentPayment> getPayments() { return payments; }
    public void setPayments(List<RentPayment> payments) { this.payments = payments; }
}
