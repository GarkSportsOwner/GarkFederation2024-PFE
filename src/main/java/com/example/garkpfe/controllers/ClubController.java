package com.example.garkpfe.controllers;

import com.example.garkpfe.entities.Club;
import com.example.garkpfe.payload.request.ClubRequest;
import com.example.garkpfe.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllClubs(){
        return clubService.getAllClubs();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getClubById(@PathVariable Integer id) {
        return clubService.getClubById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<?> createClub(@Valid @RequestBody ClubRequest clubRequest){
        return clubService.createClub(clubRequest);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClub(@PathVariable Integer id, @RequestBody Club club){
        return clubService.updateClub(id,club);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClub(@PathVariable Integer id){
        return clubService.deleteClub(id);
    }

}
