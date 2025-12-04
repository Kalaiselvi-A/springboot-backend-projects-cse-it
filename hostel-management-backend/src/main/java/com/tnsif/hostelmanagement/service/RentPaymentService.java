package com.tnsif.hostelmanagement.service;

import com.tnsif.hostelmanagement.entity.RentPayment;
import com.tnsif.hostelmanagement.entity.Tenant;
import com.tnsif.hostelmanagement.repository.RentPaymentRepository;
import com.tnsif.hostelmanagement.repository.TenantRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentPaymentService {

    private final RentPaymentRepository rentPaymentRepository;
    private final TenantRepository tenantRepository;

    public RentPaymentService(RentPaymentRepository rentPaymentRepository,
                              TenantRepository tenantRepository) {
        this.rentPaymentRepository = rentPaymentRepository;
        this.tenantRepository = tenantRepository;
    }

    // Get all payments
    public List<RentPayment> getAllPayments() {
        return rentPaymentRepository.findAll();
    }

    // Get payment by ID
    public RentPayment getPaymentById(Long id) {
        return rentPaymentRepository.findById(id).orElse(null);
    }

    // Add payment for a tenant
    public RentPayment addPayment(RentPayment payment, Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId).orElse(null);
        payment.setTenant(tenant);
        return rentPaymentRepository.save(payment);
    }

    // Update payment
    public RentPayment updatePayment(Long id, RentPayment updatedPayment) {
        RentPayment payment = rentPaymentRepository.findById(id).orElse(null);

        if (payment == null) return null;

        payment.setAmount(updatedPayment.getAmount());
        payment.setPaymentDate(updatedPayment.getPaymentDate());
        payment.setPaymentMethod(updatedPayment.getPaymentMethod());
        payment.setTenant(updatedPayment.getTenant());

        return rentPaymentRepository.save(payment);
    }

    // Delete payment
    public void deletePayment(Long id) {
        rentPaymentRepository.deleteById(id);
    }
}
