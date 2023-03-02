package com.pack.spring_mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @Column( name="idrole")
    int idRole;
    @Column( name="nom")
    String nom;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNom() {
        return nom;
    }

    public int getIdRole() {
        return idRole;
    }
}
