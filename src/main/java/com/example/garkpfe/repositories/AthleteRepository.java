package com.example.garkpfe.repositories;

import com.example.garkpfe.entities.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete,Integer> {
    Optional<Athlete> findByName(String name);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
}
