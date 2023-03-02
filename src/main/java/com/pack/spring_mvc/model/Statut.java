package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
public class Statut {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idstatut")
    private Integer idStatut;

    @Column( name = "nom")
    private String nom;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdStatut(Integer idStatut) {
        this.idStatut = idStatut;
    }

    public String getNom() {
        return nom;
    }

    public Integer getIdStatut() {
        return idStatut;
    }
}
