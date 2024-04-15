package com.example.garkpfe.services;

import com.example.garkpfe.entities.Licencie;
import com.example.garkpfe.payload.request.LicencieRequest;
import org.springframework.http.ResponseEntity;

public interface LicencieService {
    ResponseEntity<?> getAllLicencies();
    ResponseEntity<?> createLicencie(LicencieRequest licencieRequest);
    ResponseEntity<?> getLicencieById(Integer id);
    ResponseEntity<?> updateLicencie(Integer id, Licencie licencie);
    ResponseEntity<?> deleteLicencie(Integer id);
}
