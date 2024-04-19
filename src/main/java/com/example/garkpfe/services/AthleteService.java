package com.example.garkpfe.services;

import com.example.garkpfe.entities.Athlete;
import com.example.garkpfe.payload.request.AthleteRequest;
import org.springframework.http.ResponseEntity;

public interface AthleteService {
    ResponseEntity<?> getAllAthletes();
    ResponseEntity<?> createAthlete(AthleteRequest athleteRequest);
    ResponseEntity<?> getAthleteById(Integer id);
    ResponseEntity<?> updateAthlete(Integer id, Athlete athlete);
    ResponseEntity<?> deleteAthlete(Integer id);

}
