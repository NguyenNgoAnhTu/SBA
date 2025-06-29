package com.example.orchidbe.service;

import com.example.orchidbe.DTO.RoleDTO;
import com.example.orchidbe.model.Role;
import com.example.orchidbe.repository.RoleRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RoleDTO.RoleResponse getRole(String id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
        return modelMapper.map(role, RoleDTO.RoleResponse.class);

    }

    @Override
    public RoleDTO.RoleResponse insertRole(RoleDTO.RoleRequest roleRequest) {
        Role role = modelMapper.map(roleRequest, Role.class);
        Role savedRole = roleRepository.save(role);
        return modelMapper.map(savedRole, RoleDTO.RoleResponse.class);
    }

    @Override
    public List<RoleDTO.RoleResponse> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
                .map(role -> modelMapper.map(role, RoleDTO.RoleResponse.class))
                .collect(Collectors.toList());    }

    @Override
    public RoleDTO.RoleResponse updateRole(String id, RoleDTO.RoleRequest roleRequest) {
        if (!roleRepository.existsById(id)) {
            throw new EntityExistsException("Role not found with id: " + id);
        }
        Role role = modelMapper.map(roleRequest, Role.class);
        Role updatedRole = roleRepository.save(role);

        return modelMapper.map(updatedRole, RoleDTO.RoleResponse.class);
    }

    @Override
    public void deleteRole(String id) {
        if (!roleRepository.existsById(id)) {
            throw new EntityExistsException("Role not found with id: " + id);
        }
        roleRepository.deleteById(id);
    }
}
