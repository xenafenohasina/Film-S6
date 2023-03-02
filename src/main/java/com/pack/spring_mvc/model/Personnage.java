package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
public class Personnage {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idpersonnage")
    private Integer idPersonnage;

    @Column( name = "nom")
    private String nom;

    @Column( name = "descriptions")
    private String descriptions;

    @Column( name = "idFilms")
    private Integer idFilms;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdFilms(Integer idFilms) {
        this.idFilms = idFilms;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setIdPersonnage(Integer idPersonnage) {
        this.idPersonnage = idPersonnage;
    }

    public Integer getIdFilms() {
        return idFilms;
    }

    public String getNom() {
        return nom;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public Integer getIdPersonnage() {
        return idPersonnage;
    }
}
