package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaction")
    private int idAction;

    @Column(name = "descriptions")
    private String descriptions;

    @ManyToOne
    @JoinColumn(name = "idscenario")
    private Scenario scenario;

    @ManyToOne
    @JoinColumn(name = "idpersonnage")
    private  Personnage personnage;

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    public int getIdAction() {
        return idAction;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }
}
