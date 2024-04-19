package com.example.garkpfe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@JsonIgnore
    @OneToMany(mappedBy = "club",cascade = CascadeType.ALL)
    private List<Licencie> licencies;
    @ManyToOne
    @JoinColumn(name = "federation_id")
    private Federation federation;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Licencie> getLicencies() {
        return licencies;
    }

    public void setLicencies(List<Licencie> licencies) {
        this.licencies = licencies;
    }

    public Federation getFederation() {
        return federation;
    }

    public void setFederation(Federation federation) {
        this.federation = federation;
    }


    public Club(String name, String email, String address, String siteWeb, String description) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.siteWeb = siteWeb;
        this.description=description;


    }
}

