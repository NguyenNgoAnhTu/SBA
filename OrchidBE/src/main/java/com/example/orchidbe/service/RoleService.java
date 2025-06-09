package com.example.orchidbe.service;

import com.example.orchidbe.model.Role;

import java.util.List;

public interface RoleService {
     Role getRole(Long id);
     Role insertRole(Role role) ;
     List<Role> getAllRoles();
    Role updateRole(Role role);
    void deleteRole(Long id);
}
