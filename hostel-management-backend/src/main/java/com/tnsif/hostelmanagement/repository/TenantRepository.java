package com.tnsif.hostelmanagement.repository;

import com.tnsif.hostelmanagement.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    // Find tenants by room ID (optional)
    // List<Tenant> findByRoomId(Long roomId);
}
