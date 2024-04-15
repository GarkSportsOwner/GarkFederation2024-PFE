package com.example.garkpfe.repositories;

import com.example.garkpfe.entities.Federation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FederationRepository extends JpaRepository<Federation,Integer> {
    Optional<Federation> findByName(String name);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);

    boolean existsBySiteWeb(String siteWeb);

}
