package com.example.garkpfe.services.servicesImpl;

import com.example.garkpfe.entities.Federation;
import com.example.garkpfe.payload.request.FederationRequest;
import com.example.garkpfe.payload.response.MessageResponse;
import com.example.garkpfe.repositories.FederationRepository;
import com.example.garkpfe.services.FederationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FederationServiceTmpl implements FederationService {
    @Autowired
    private FederationRepository federationRepository;

    @Override
    public ResponseEntity<List<Federation>> getAllFederations() {
        List<Federation> federations = federationRepository.findAll();
        return new ResponseEntity<>(federations, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Federation> getFederationById(Integer id) {
        Optional<Federation> federationOptional = federationRepository.findById(id);
        return federationOptional.map(federation -> new ResponseEntity<>(federation, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    public ResponseEntity<?> createFederation(@Valid FederationRequest federationRequest) {
        if (federationRepository.existsByName(federationRequest.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Federation name is already taken!"));
        }

        if (federationRepository.existsBySiteWeb(federationRequest.getSiteWeb())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: SiteWeb is already in use!"));
        }

        Federation federation = new Federation(federationRequest.getName(),federationRequest.getEmail(), federationRequest.getAddress(), federationRequest.getSiteWeb(), federationRequest.getLogo());
        federationRepository.save(federation);
        return ResponseEntity.ok(new MessageResponse("Federation created successfully"));
    }
    @Override
    public ResponseEntity<?> updateFederation(Integer id, Federation federation) {
        Optional<Federation> federationOptional = federationRepository.findById(id);
        if (federationOptional.isPresent()) {
            Federation existingFederation = federationOptional.get();
            existingFederation.setName(federation.getName());
            existingFederation.setEmail(federation.getEmail());
            existingFederation.setAddress(federation.getAddress());
            existingFederation.setSiteWeb(federation.getSiteWeb());
            existingFederation.setLogo(federation.getLogo());
            federationRepository.save(existingFederation);
            return ResponseEntity.ok(new MessageResponse("Federation updated successfully"));
        } else {
            return new ResponseEntity<>("Federation not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteFederation(Integer id) {
        if (federationRepository.existsById(id)) {
            federationRepository.deleteById(id);
            return ResponseEntity.ok(new MessageResponse("Federation deleted successfully"));
        } else {
            return new ResponseEntity<>("Federation not found", HttpStatus.NOT_FOUND);
        }
    }
}

