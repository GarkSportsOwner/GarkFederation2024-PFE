package com.example.garkpfe.services;

import com.example.garkpfe.entities.Club;
import com.example.garkpfe.payload.request.ClubRequest;
import org.springframework.http.ResponseEntity;

public interface ClubService {
    ResponseEntity<?> getAllClubs();
    ResponseEntity<?> createClub(ClubRequest clubRequest);
    ResponseEntity<?> getClubById(Integer id);
    ResponseEntity<?> updateClub(Integer id, Club club);
    ResponseEntity<?> deleteClub(Integer id);
}
