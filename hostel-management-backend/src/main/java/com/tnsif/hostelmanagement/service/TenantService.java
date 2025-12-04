package com.tnsif.hostelmanagement.service;

import com.tnsif.hostelmanagement.entity.Tenant;
import com.tnsif.hostelmanagement.entity.Room;
import com.tnsif.hostelmanagement.repository.TenantRepository;
import com.tnsif.hostelmanagement.repository.RoomRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;
    private final RoomRepository roomRepository;

    public TenantService(TenantRepository tenantRepository, RoomRepository roomRepository) {
        this.tenantRepository = tenantRepository;
        this.roomRepository = roomRepository;
    }

    // Get all tenants
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    // Get tenant by ID
    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id).orElse(null);
    }

    // Add tenant & assign room
    public Tenant addTenant(Tenant tenant, Long roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        tenant.setRoom(room);
        return tenantRepository.save(tenant);
    }

    // Update tenant
    public Tenant updateTenant(Long id, Tenant updatedTenant) {
        Tenant tenant = tenantRepository.findById(id).orElse(null);
        if (tenant == null) return null;

        tenant.setName(updatedTenant.getName());
        tenant.setEmail(updatedTenant.getEmail());
        tenant.setPhone(updatedTenant.getPhone());
        tenant.setJoiningDate(updatedTenant.getJoiningDate());
        tenant.setLeavingDate(updatedTenant.getLeavingDate());
        tenant.setRoom(updatedTenant.getRoom());

        return tenantRepository.save(tenant);
    }

    // Delete tenant
    public void deleteTenant(Long id) {
        tenantRepository.deleteById(id);
    }
}
