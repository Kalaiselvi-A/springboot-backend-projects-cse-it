package com.tnsif.hostelmanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class RentPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;            // Rent paid
    private LocalDate paymentDate;    // Payment date
    private String paymentMethod;     // Cash, Online, UPI, etc.

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;            // Tenant who paid

    // Constructors
    public RentPayment() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public Tenant getTenant() { return tenant; }
    public void setTenant(Tenant tenant) { this.tenant = tenant; }
}
