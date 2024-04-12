package com.example.garkpfe.services;

import com.example.garkpfe.entities.User;
import com.example.garkpfe.payload.request.LoginRequest;
import com.example.garkpfe.payload.request.SignupRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface AuthService {
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
    ResponseEntity<?> registerUser(SignupRequest signupRequest);
    ResponseEntity<?> logout();
    ResponseEntity<?> refreshToken(HttpServletRequest request);


}
