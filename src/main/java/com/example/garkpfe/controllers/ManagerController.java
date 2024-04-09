package com.example.garkpfe.controllers;

import com.example.garkpfe.payload.request.SignupRequest;
import com.example.garkpfe.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @Autowired
    private AuthService authService;


    @PreAuthorize("hasRole('MANAGER')or hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        authService.registerUser(signUpRequest);
        return ResponseEntity.ok("Member created successfully");

    }
}
