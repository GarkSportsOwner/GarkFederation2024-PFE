package com.example.garkpfe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "athlete")
public class Athlete{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String telephone;

    public Athlete(String name, String email, String address, String telephone) {
        this.name =name;
        this.email = email;
        this.address = address;
        this.telephone=telephone;
    }
}
