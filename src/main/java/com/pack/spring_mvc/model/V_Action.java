package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
public class V_Action {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idaction")
    private Integer idAction;

    @Column( name = "descriptions")
    private String descriptions;

    @Column( name = "idscenario")
    private int idScenario;

    @Column( name = "idpersonnage")
    private int idPersonnage;

    @Column( name = "nom")
    private String nom;

    public Integer getIdAction() {
        return idAction;
    }

    public void setIdAction(Integer idAction) {
        this.idAction = idAction;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getIdScenario() {
        return idScenario;
    }

    public void setIdScenario(int idScenario) {
        this.idScenario = idScenario;
    }

    public int getIdPersonnage() {
        return idPersonnage;
    }

    public void setIdPersonnage(int idPersonnage) {
        this.idPersonnage = idPersonnage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
