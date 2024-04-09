package com.example.garkpfe.controllers;


import com.example.garkpfe.payload.request.LoginRequest;
import com.example.garkpfe.payload.request.SignupRequest;
import com.example.garkpfe.security.services.RefreshTokenService;
import com.example.garkpfe.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Autowired
    RefreshTokenService refreshTokenService;

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return authService.registerUser(signUpRequest);
    }
//    @PostMapping("/add/admin")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//        return authService.registerUser(signUpRequest);
//    }
    @PostMapping("/sign-out")
    public ResponseEntity<?> logoutUser() {
        return authService.logoutUser();
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        return authService.refreshToken(request);
    }
    }