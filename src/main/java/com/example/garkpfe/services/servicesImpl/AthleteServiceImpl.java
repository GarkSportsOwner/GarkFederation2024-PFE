package com.example.garkpfe.services.servicesImpl;

import com.example.garkpfe.entities.Athlete;
import com.example.garkpfe.entities.Licencie;
import com.example.garkpfe.payload.request.AthleteRequest;
import com.example.garkpfe.payload.request.LicencieRequest;
import com.example.garkpfe.payload.response.MessageResponse;
import com.example.garkpfe.repositories.AthleteRepository;
import com.example.garkpfe.repositories.LicencieRepository;
import com.example.garkpfe.services.AthleteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AthleteServiceImpl implements AthleteService {
    @Autowired
    private AthleteRepository athleteRepository;

    public ResponseEntity<List<Athlete>> getAllAthletes() {
        List<Athlete> athletes = athleteRepository.findAll();
        return new ResponseEntity<>(athletes, HttpStatus.OK);
    }

    public ResponseEntity<Athlete> getAthleteById(Integer id) {
        Optional<Athlete> athleteOptional = athleteRepository.findById(id);
        return athleteOptional.map(athlete -> new ResponseEntity<>(athlete, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<?> createAthlete(@Valid AthleteRequest athleteRequest) {
        if (athleteRepository.existsByName(athleteRequest.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Athlete name is already taken!"));
        }

        if (athleteRepository.existsByEmail(athleteRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        Athlete athlete = new Athlete(athleteRequest.getName(), athleteRequest.getEmail(), athleteRequest.getAddress(),athleteRequest.getTelephone());
        athleteRepository.save(athlete);
        return ResponseEntity.ok(new MessageResponse("Club created successfully"));
    }

    public ResponseEntity<?> updateAthlete(Integer id, Athlete athlete) {
        Optional<Athlete> athleteOptional = athleteRepository.findById(id);
        if (athleteOptional.isPresent()) {
            Athlete existingAthlete = athleteOptional.get();
            existingAthlete.setName(athlete.getName());
            existingAthlete.setEmail(athlete.getEmail());
            existingAthlete.setAddress(athlete.getAddress());
            existingAthlete.setTelephone(athlete.getTelephone());
            athleteRepository.save(existingAthlete);
            return ResponseEntity.ok(new MessageResponse("Athlete updated successfully"));
        } else {
            return new ResponseEntity<>("Athlete not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteAthlete(Integer id) {
        if (athleteRepository.existsById(id)) {
            athleteRepository.deleteById(id);
            return ResponseEntity.ok(new MessageResponse("Athlete deleted successfully"));
        } else {
            return new ResponseEntity<>("Athlete not found", HttpStatus.NOT_FOUND);
        }
    }
}




