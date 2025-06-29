package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrchidDTO;
import com.example.orchidbe.model.Category;
import com.example.orchidbe.model.Orchid;
import com.example.orchidbe.repository.CategoryRepository;
import com.example.orchidbe.repository.OrchidRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrchidServiceImpl implements OrchidService{
    private final OrchidRepository orchidRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    @Override
    public OrchidDTO.OrchidResponse createOrchid(OrchidDTO.OrchidRequest orchidRequest) {
        Category category = categoryRepository.findById(orchidRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + orchidRequest.getCategoryId()));

        Orchid orchid = Orchid.builder()
                .orchidName(orchidRequest.getName())
                .orchidDecription(orchidRequest.getDescription())
                .price(orchidRequest.getPrice())
                .orchidUrl(orchidRequest.getImageUrl())
                .category(category)
                .build();

        Orchid savedOrchid = orchidRepository.save(orchid);

            return modelMapper.map(savedOrchid, OrchidDTO.OrchidResponse.class);
    }

    @Override
    public OrchidDTO.OrchidResponse getOrchidById(Long id) {
        Orchid orchid = orchidRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orchid not found with id: " + id));
        return modelMapper.map(orchid, OrchidDTO.OrchidResponse.class);
    }

    @Override
    public List<OrchidDTO.OrchidResponse> getAllOrchids() {
        return orchidRepository.findAll()
                .stream().map(x -> modelMapper.map(x, OrchidDTO.OrchidResponse.class)).toList();
    }

    @Override
    public OrchidDTO.OrchidResponse updateOrchid(Long id, OrchidDTO.OrchidRequest orchidRequest) {
        Orchid orchid = orchidRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orchid not found with id: " + id));
        orchid.setOrchidName(orchidRequest.getName());
        orchid.setOrchidDecription(orchidRequest.getDescription());
        orchid.setPrice(orchidRequest.getPrice());
        orchid.setOrchidUrl(orchidRequest.getImageUrl());
        orchid.setCategory(categoryRepository.findById(orchidRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + orchidRequest.getCategoryId()))
        );
        Orchid updatedOrchid = orchidRepository.save(orchid);

        return modelMapper.map(updatedOrchid, OrchidDTO.OrchidResponse.class);
    }

    @Override
    public void deleteOrchid(Long id) {
        if (!orchidRepository.existsById(id)) {
            throw new RuntimeException("Orchid not found with id: " + id);
        }
        orchidRepository.deleteById(id);

    }

    @Override
    public List<OrchidDTO.OrchidResponse> getOrchidsByCategory(Long categoryId) {


        List<Orchid> orchids = orchidRepository.findByCategoryCategoryId(categoryId);
        return orchids.stream()
                .map(orchid -> modelMapper.map(orchid, OrchidDTO.OrchidResponse.class))
                .collect(Collectors.toList());
    }
}
