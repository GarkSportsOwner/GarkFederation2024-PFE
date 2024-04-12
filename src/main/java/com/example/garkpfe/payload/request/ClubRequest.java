package com.example.garkpfe.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClubRequest {
    private String name;
    private String email;
    private String address;
    private String siteWeb;
    private String description;
}
