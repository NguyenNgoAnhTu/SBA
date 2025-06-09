package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrchidDTO;

import java.util.List;

public interface OrchidService {
    OrchidDTO.OrchidResponse createOrchid(OrchidDTO.OrchidRequest orchidRequest);
    OrchidDTO.OrchidResponse getOrchidById(Long id);
    List<OrchidDTO.OrchidResponse> getAllOrchids();
    OrchidDTO.OrchidResponse updateOrchid(Long id, OrchidDTO.OrchidRequest orchidRequest);
    void deleteOrchid(Long id);
    List<OrchidDTO.OrchidResponse> getOrchidsByCategory(Long categoryId);
}
