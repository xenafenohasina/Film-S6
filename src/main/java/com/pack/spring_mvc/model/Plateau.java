package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
public class Plateau {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idplateau")
    private Integer idPlateau;

    @Column( name = "nom")
    private String nom;

    public Integer getIdPlateau() {
        return idPlateau;
    }

    public void setIdPlateau(Integer idPlateau) {
        this.idPlateau = idPlateau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
