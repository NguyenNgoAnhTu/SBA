package com.example.orchidbe.service;

import com.example.orchidbe.DTO.RoleDTO;
import com.example.orchidbe.model.Role;

import java.util.List;

public interface RoleService {

     RoleDTO.RoleResponse getRole(String id);
     RoleDTO.RoleResponse insertRole(RoleDTO.RoleRequest role) ;
     List<RoleDTO.RoleResponse> getAllRoles();
    RoleDTO.RoleResponse updateRole(String id,RoleDTO.RoleRequest role);
    void deleteRole(String id);
}
