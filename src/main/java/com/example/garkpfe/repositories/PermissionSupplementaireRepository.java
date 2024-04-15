package com.example.garkpfe.repositories;

import com.example.garkpfe.entities.PermissionSupplementaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionSupplementaireRepository extends JpaRepository<PermissionSupplementaire,Integer> {
    Optional<PermissionSupplementaire> findByName(String name);
}
