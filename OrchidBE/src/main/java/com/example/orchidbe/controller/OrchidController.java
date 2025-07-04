package com.example.orchidbe.controller;

import com.example.orchidbe.DTO.OrchidDTO;
import com.example.orchidbe.service.OrchidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orchids")
@RequiredArgsConstructor
public class OrchidController {

    private final OrchidService orchidService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrchidById(@PathVariable Long id) {
        try {
            var orchid = orchidService.getOrchidById(id);
            return ResponseEntity.ok(orchid);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Orchid not found with id: " + id);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllOrchids() {
        try {
            var orchids = orchidService.getAllOrchids();
            return ResponseEntity.ok(orchids);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving orchids: " + e.getMessage());
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createOrchid(
            @Valid @RequestBody OrchidDTO.OrchidRequest orchidRequest,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body("Validation errors: " + bindingResult.getAllErrors());
        }

        try {
            var orchid = orchidService.createOrchid(orchidRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(orchid);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error creating orchid: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateOrchid(
            @PathVariable Long id,
            @Valid @RequestBody OrchidDTO.OrchidRequest orchidRequest,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body("Validation errors: " + bindingResult.getAllErrors());
        }

        try {
            var orchid = orchidService.updateOrchid(id, orchidRequest);
            return ResponseEntity.ok(orchid);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error updating orchid: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteOrchid(@PathVariable Long id) {
        try {
            orchidService.deleteOrchid(id);
            return ResponseEntity.ok("Orchid deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error deleting orchid: " + e.getMessage());
        }
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<OrchidDTO.OrchidResponse>> getOrchidsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(orchidService.getOrchidsByCategory(categoryId));
    }
}