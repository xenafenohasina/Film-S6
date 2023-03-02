package com.pack.spring_mvc.model;

import com.pack.spring_mvc.model.Role;

import javax.persistence.*;
@Entity
public class Utilisateur {

    @Id
    int idutilisateur;
    String nom;
    String email;
    String motdepasse;
   // @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "idrole",referencedColumnName = "idrole")
    //Role role;

    int idrole;

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

/*    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    } */
}
