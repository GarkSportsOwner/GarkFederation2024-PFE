package com.example.garkpfe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "club")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String siteWeb;
    private String description;

    public Club(String name, String email, String address, String siteWeb,String description) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.siteWeb = siteWeb;
        this.description=description;
    }
}

