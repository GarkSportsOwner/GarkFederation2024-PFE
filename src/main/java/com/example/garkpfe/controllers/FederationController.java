package com.example.garkpfe.controllers;

import com.example.garkpfe.entities.Federation;
import com.example.garkpfe.payload.request.FederationRequest;
import com.example.garkpfe.services.FederationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/federation")
public class FederationController {
    @Autowired
    private FederationService federationService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllFederations() {
        return federationService.getAllFederations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFederationById(@PathVariable Integer id) {
        return federationService.getFederationById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createFederation(@Valid @RequestBody FederationRequest federationRequest) {
        return federationService.createFederation(federationRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFederation(@PathVariable Integer id, @RequestBody Federation federation) {
        return federationService.updateFederation(id, federation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFederation(@PathVariable Integer id) {
        return federationService.deleteFederation(id);
    }
}
