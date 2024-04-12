package com.example.garkpfe.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AthleteRequest {
    private String name;
    private String address;
    private String telephone;
    private String email;
}
