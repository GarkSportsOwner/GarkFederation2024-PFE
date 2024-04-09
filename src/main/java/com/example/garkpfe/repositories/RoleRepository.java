package com.example.garkpfe.repositories;

import com.example.garkpfe.entities.ERole;
import com.example.garkpfe.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {
Optional<Role> findByName (ERole name);

}
