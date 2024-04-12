package com.example.garkpfe.repositories;

import com.example.garkpfe.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club,Integer> {

    Optional<Club> findByName(String name);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);

    boolean existsBySiteWeb(String siteWeb);
}
