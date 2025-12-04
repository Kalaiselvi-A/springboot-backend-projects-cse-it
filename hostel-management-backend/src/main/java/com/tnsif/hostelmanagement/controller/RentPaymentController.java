package com.tnsif.hostelmanagement.controller;

import com.tnsif.hostelmanagement.entity.RentPayment;
import com.tnsif.hostelmanagement.service.RentPaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class RentPaymentController {

    private final RentPaymentService paymentService;

    public RentPaymentController(RentPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<RentPayment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public RentPayment getPayment(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/add/{tenantId}")
    public RentPayment addPayment(@RequestBody RentPayment payment, @PathVariable Long tenantId) {
        return paymentService.addPayment(payment, tenantId);
    }

    @PutMapping("/{id}")
    public RentPayment updatePayment(@PathVariable Long id, @RequestBody RentPayment payment) {
        return paymentService.updatePayment(id, payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
