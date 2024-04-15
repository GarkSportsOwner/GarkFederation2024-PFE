package com.example.garkpfe.controllers;

import com.example.garkpfe.entities.Federation;
import com.example.garkpfe.payload.request.FederationRequest;
import com.example.garkpfe.services.FederationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private FederationService federationService;

    @GetMapping("/federation/all")
    public ResponseEntity<?> getAllFederations(){
        return federationService.getAllFederations();
    }
    @GetMapping("/federation/{id}")
    public ResponseEntity<?> getAthleteById(@PathVariable Integer id) {
        return federationService.getFederationById(id);
    }
    @PostMapping("/federation/add")
    public ResponseEntity<?> createFederation(@Valid @RequestBody FederationRequest federationRequest){
        return federationService.createFederation(federationRequest);
    }
    @PutMapping("/federation/{id}")
    public ResponseEntity<?> updateAthlete(@PathVariable Integer id, @RequestBody Federation federation){
        return federationService.updateFederation(id,federation);

    }
    @DeleteMapping("/federation/{id}")

    public ResponseEntity<?> deleteFederation(@PathVariable Integer id){
        return federationService.deleteFederation(id);
    }
}

