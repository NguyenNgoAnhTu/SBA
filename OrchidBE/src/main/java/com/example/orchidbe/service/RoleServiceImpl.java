package com.example.orchidbe.service;

import com.example.orchidbe.model.Role;
import com.example.orchidbe.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role getRole(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role insertRole(Role role) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return List.of();
    }

    @Override
    public Role updateRole(Role role) {
        return null;
    }

    @Override
    public void deleteRole(Long id) {

    }
}
