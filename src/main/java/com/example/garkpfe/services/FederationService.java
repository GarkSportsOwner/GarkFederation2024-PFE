package com.example.garkpfe.services;

import com.example.garkpfe.entities.Club;
import com.example.garkpfe.entities.Federation;
import com.example.garkpfe.payload.request.ClubRequest;
import com.example.garkpfe.payload.request.FederationRequest;
import org.springframework.http.ResponseEntity;

public interface FederationService {
    ResponseEntity<?> getAllFederations();
    ResponseEntity<?> createFederation(FederationRequest federationRequest);
    ResponseEntity<?> getFederationById(Integer id);
    ResponseEntity<?> updateFederation(Integer id, Federation federation);
    ResponseEntity<?> deleteFederation(Integer id);
}
