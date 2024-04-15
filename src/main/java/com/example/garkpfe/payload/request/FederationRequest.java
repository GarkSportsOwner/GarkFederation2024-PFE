package com.example.garkpfe.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FederationRequest {
    private String name;
    private String address;
    private String email;
    private String siteWeb;
    private String logo;
}
