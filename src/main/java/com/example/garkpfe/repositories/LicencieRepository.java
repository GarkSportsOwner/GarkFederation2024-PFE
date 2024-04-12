package com.example.garkpfe.repositories;

import com.example.garkpfe.entities.Licencie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LicencieRepository  extends JpaRepository<Licencie,Integer> {
    Optional<Licencie> findByName(String name);
    Boolean existsByName(String name);

    Boolean existsByEmail(String email);
    List<Licencie> findByStatus(String status);


}
