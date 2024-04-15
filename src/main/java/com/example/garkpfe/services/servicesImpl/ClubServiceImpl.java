package com.example.garkpfe.services.servicesImpl;

import com.example.garkpfe.entities.Club;
import com.example.garkpfe.payload.request.ClubRequest;
import com.example.garkpfe.payload.response.MessageResponse;
import com.example.garkpfe.repositories.ClubRepository;
import com.example.garkpfe.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public ResponseEntity<List<Club>> getAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Club> getClubById(Integer id) {
        Optional<Club> clubOptional = clubRepository.findById(id);
        return clubOptional.map(club -> new ResponseEntity<>(club, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    public ResponseEntity<?> createClub(@Valid ClubRequest clubRequest) {
        if (clubRepository.existsByName(clubRequest.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Club name is already taken!"));
        }

        if (clubRepository.existsBySiteWeb(clubRequest.getSiteWeb())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: SiteWeb is already in use!"));
        }

        Club club = new Club(clubRequest.getName(),clubRequest.getEmail(), clubRequest.getAddress(), clubRequest.getSiteWeb(), clubRequest.getDescription());
        clubRepository.save(club);
        return ResponseEntity.ok(new MessageResponse("Club created successfully"));
    }
@Override
    public ResponseEntity<?> updateClub(Integer id, Club club) {
        Optional<Club> clubOptional = clubRepository.findById(id);
        if (clubOptional.isPresent()) {
            Club existingClub = clubOptional.get();
            existingClub.setName(club.getName());
            existingClub.setEmail(club.getEmail());
            existingClub.setAddress(club.getAddress());
            existingClub.setSiteWeb(club.getSiteWeb());
            existingClub.setDescription(club.getDescription());
            clubRepository.save(existingClub);
            return ResponseEntity.ok(new MessageResponse("Club updated successfully"));
        } else {
            return new ResponseEntity<>("Club not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteClub(Integer id) {
        if (clubRepository.existsById(id)) {
            clubRepository.deleteById(id);
            return ResponseEntity.ok(new MessageResponse("Club deleted successfully"));
        } else {
            return new ResponseEntity<>("Club not found", HttpStatus.NOT_FOUND);
        }
    }
}
