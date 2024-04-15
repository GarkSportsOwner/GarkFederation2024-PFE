package com.example.garkpfe.services.servicesImpl;

import com.example.garkpfe.entities.Licencie;
import com.example.garkpfe.payload.request.LicencieRequest;
import com.example.garkpfe.payload.response.MessageResponse;
import com.example.garkpfe.repositories.LicencieRepository;
import com.example.garkpfe.services.LicencieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LicencieServiceImpl  implements LicencieService {
    @Autowired
    private LicencieRepository licencieRepository;

    public ResponseEntity<List<Licencie>> getAllLicencies() {
        List<Licencie> licencies = licencieRepository.findAll();
        return new ResponseEntity<>(licencies, HttpStatus.OK);
    }

    public ResponseEntity<Licencie> getLicencieById(Integer id) {
        Optional<Licencie> licencieOptional = licencieRepository.findById(id);
        return licencieOptional.map(licencie -> new ResponseEntity<>(licencie, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<?> createLicencie(@Valid LicencieRequest licencieRequest) {
        if (licencieRepository.existsByName(licencieRequest.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Licencie name is already taken!"));
        }

        if (licencieRepository.existsByEmail(licencieRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        Licencie licencie = new Licencie(licencieRequest.getName(), licencieRequest.getEmail(), licencieRequest.getStatus());
        licencieRepository.save(licencie);
        return ResponseEntity.ok(new MessageResponse("Club created successfully"));
    }

    public ResponseEntity<?> updateLicencie(Integer id, Licencie licencie) {
        Optional<Licencie> licencieOptional = licencieRepository.findById(id);
        if (licencieOptional.isPresent()) {
            Licencie existingLicencie = licencieOptional.get();
            existingLicencie.setName(licencie.getName());
            existingLicencie.setEmail(licencie.getEmail());
            existingLicencie.setStatus(licencie.getStatus());
            licencieRepository.save(existingLicencie);
            return ResponseEntity.ok(new MessageResponse("Licencie updated successfully"));
        } else {
            return new ResponseEntity<>("Licencie not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteLicencie(Integer id) {
        if (licencieRepository.existsById(id)) {
            licencieRepository.deleteById(id);
            return ResponseEntity.ok(new MessageResponse("Licencie deleted successfully"));
        } else {
            return new ResponseEntity<>("Licencie not found", HttpStatus.NOT_FOUND);
        }
    }
}


