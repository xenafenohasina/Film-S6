package com.pack.spring_mvc.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Films {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idfilms")
    private Integer idFilms;

    @Column( name = "nom")
    private String nom;

    @Column( name = "datecreation")
    private Date dateCreation;

    @Column( name = "idstatut")
    private Integer idStatut;

    @Column( name = "idutilisateur")
    private Integer idUtilisateur;

    @Column( name = "image")
    private String image;


    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setIdFilms(Integer idFilms) {
        this.idFilms = idFilms;
    }

    public void setIdStatut(Integer idStatut) {
        this.idStatut = idStatut;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public Integer getIdFilms() {
        return idFilms;
    }

    public Integer getIdStatut() {
        return idStatut;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
