package com.example.garkpfe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "federation")
public class Federation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String name;
private String address;
private String email;
private String siteWeb;
private String logo;

@OneToMany(mappedBy = "federation" , cascade = CascadeType.ALL)

    private List<Club> clubs;


    public Federation(String name, String email, String address, String siteWeb, String logo) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.siteWeb = siteWeb;
        this.logo = logo;
    }
}
