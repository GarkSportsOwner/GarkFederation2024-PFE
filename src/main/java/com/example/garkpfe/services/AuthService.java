package com.example.garkpfe.services;

import com.example.garkpfe.payload.request.LoginRequest;
import com.example.garkpfe.payload.request.SignupRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
    ResponseEntity<?> registerUser(SignupRequest signupRequest);
    ResponseEntity<?> logoutUser();
    ResponseEntity<?> refreshToken(HttpServletRequest request);



}
