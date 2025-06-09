package com.example.orchidbe.controller;

import com.example.orchidbe.model.Role;
import com.example.orchidbe.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        // Placeholder for actual implementation
        return roleService.getRole(id);
    }
}
