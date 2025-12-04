package com.tnsif.hostelmanagement.repository;

import com.tnsif.hostelmanagement.entity.RentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentPaymentRepository extends JpaRepository<RentPayment, Long> {
    // Find payments by tenant ID (optional)
    // List<RentPayment> findByTenantId(Long tenantId);
}
