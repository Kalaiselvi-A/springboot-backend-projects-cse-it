package com.tnsif.hostelmanagement.controller;

import com.tnsif.hostelmanagement.entity.Tenant;
import com.tnsif.hostelmanagement.service.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
@CrossOrigin("*")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @GetMapping("/{id}")
    public Tenant getTenant(@PathVariable Long id) {
        return tenantService.getTenantById(id);
    }

    // Add a tenant and assign to a room
    @PostMapping("/add/{roomId}")
    public Tenant addTenant(@RequestBody Tenant tenant, @PathVariable Long roomId) {
        return tenantService.addTenant(tenant, roomId);
    }

    @PutMapping("/{id}")
    public Tenant updateTenant(@PathVariable Long id, @RequestBody Tenant tenant) {
        return tenantService.updateTenant(id, tenant);
    }

    @DeleteMapping("/{id}")
    public void deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
    }
}
