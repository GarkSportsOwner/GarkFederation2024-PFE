package com.example.garkpfe.repositories;

import com.example.garkpfe.entities.RefreshToken;
import com.example.garkpfe.entities.User;
import com.example.garkpfe.security.services.RefreshTokenService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Integer> {

    Optional<RefreshToken> findByToken(String token);
    @Modifying
    int deleteByUser(User user);
}
