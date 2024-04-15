package com.example.garkpfe.controllers;

import com.example.garkpfe.entities.Licencie;
import com.example.garkpfe.payload.request.LicencieRequest;
import com.example.garkpfe.services.LicencieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/licencie")
public class LicencieController {
    @Autowired
    private LicencieService licencieService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllLicencies(){
        return licencieService.getAllLicencies();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getLicencieById(@PathVariable Integer id) {
        return licencieService.getLicencieById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<?> createLicencie(@Valid @RequestBody LicencieRequest licencieRequest){
        return licencieService.createLicencie(licencieRequest);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLicencie(@PathVariable Integer id, @RequestBody Licencie licencie){
        return licencieService.updateLicencie(id,licencie);

    }
    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteLicencie(@PathVariable Integer id){
        return licencieService.deleteLicencie(id);
    }
}
