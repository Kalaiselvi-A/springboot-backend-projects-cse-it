package com.tnsif.hostelmanagement.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;    // Room number like 101, 102
    private String roomType;      // Single, Double, Triple
    private int floor;            // Floor number
    private boolean isOccupied;   // Occupied or not
    private double rentAmount;    // Rent per month
    private String description;   // Additional info about room

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Tenant> tenants; // List of tenants in this room

    // Constructors
    public Room() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }
    public boolean isOccupied() { return isOccupied; }
    public void setOccupied(boolean occupied) { isOccupied = occupied; }
    public double getRentAmount() { return rentAmount; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<Tenant> getTenants() { return tenants; }
    public void setTenants(List<Tenant> tenants) { this.tenants = tenants; }
}
