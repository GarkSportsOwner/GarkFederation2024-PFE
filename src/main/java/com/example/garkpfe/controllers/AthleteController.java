package com.example.garkpfe.controllers;

import com.example.garkpfe.entities.Athlete;
import com.example.garkpfe.payload.request.AthleteRequest;
import com.example.garkpfe.services.AthleteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/athlete")
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllAthletes(){
        return athleteService.getAllAthletes();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAthleteById(@PathVariable Integer id) {
        return athleteService.getAthleteById(id);
    }
        @PostMapping("/add")
                public ResponseEntity<?> createAthlete(@Valid @RequestBody AthleteRequest athleteRequest){
        return athleteService.createAthlete(athleteRequest);
        }
        @PutMapping("/{id}")
    public ResponseEntity<?> updateAthlete(@PathVariable Integer id, @RequestBody Athlete athlete){
        return athleteService.updateAthlete(id,athlete);

    }
    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteAthlete(@PathVariable Integer id){
        return athleteService.deleteAthlete(id);
    }
}
