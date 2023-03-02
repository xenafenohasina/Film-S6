package com.pack.spring_mvc.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class V_Films {

    @Id
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

    @Column( name = "statut")
    private String statut;

    private String image;

    private  String nomutilisateur;

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

    public void setIdStatut(Integer idStatus) {
        this.idStatut = idStatus;
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

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }
    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
