package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrchidDTO;

import java.util.List;

public interface OrchidService {
    OrchidDTO.OrchidResponse createOrchid(OrchidDTO.OrchidRequest orchidRequest);
    OrchidDTO.OrchidResponse getOrchidById(String id);
    List<OrchidDTO.OrchidResponse> getAllOrchids();
    OrchidDTO.OrchidResponse updateOrchid(String id, OrchidDTO.OrchidRequest orchidRequest);
    void deleteOrchid(String id);
    List<OrchidDTO.OrchidResponse> getOrchidsByCategory(String categoryId);
}
