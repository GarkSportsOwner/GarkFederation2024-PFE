package com.example.garkpfe.payload.request;

import com.example.garkpfe.entities.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SignupRequest {

    private String username;
    private String email;
    private String password;
    private Set<String> role;
}
