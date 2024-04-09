package com.example.garkpfe.payload.request;

import com.example.garkpfe.entities.Role;
import lombok.*;

import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignupRequest {

    private String username;
    private String email;
    private String password;
    private Set<String> role;
}
