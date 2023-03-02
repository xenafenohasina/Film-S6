package com.pack.spring_mvc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "v_PersonnageFilms")
public class VPersonnageFilms {
    @Id
    int idfilms;
    String nom;
    Date datecreation;
    int idstatut;
    int idutilisateur;
    int idacteur;
    String nompersonnage;

    public int getId() {
        return idfilms;
    }

    public void setId(int id) {
        this.idfilms = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public int getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(int idstatut) {
        this.idstatut = idstatut;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdacteur() {
        return idacteur;
    }

    public void setIdacteur(int idacteur) {
        this.idacteur = idacteur;
    }

    public String getNompersonnage() {
        return nompersonnage;
    }

    public void setNompersonnage(String nompersonnage) {
        this.nompersonnage = nompersonnage;
    }
}
