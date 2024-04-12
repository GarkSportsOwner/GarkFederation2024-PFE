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
@Table(name = "licencie")
public class Licencie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String email;
    private String status;

    public Licencie(String name, String email, String status) {
        this.name=name;
        this.email = email;
        this.status = status;
    }
}
