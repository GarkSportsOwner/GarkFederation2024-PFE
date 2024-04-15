package com.example.garkpfe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

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

    @OneToMany(mappedBy = "club",cascade = CascadeType.ALL)
    private List<Licencie> licencies;
    @ManyToOne
    @JoinColumn(name = "federation_id")
    private Federation federation;
    public Club(String name, String email, String address, String siteWeb,String description) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.siteWeb = siteWeb;
        this.description=description;
    }
}

