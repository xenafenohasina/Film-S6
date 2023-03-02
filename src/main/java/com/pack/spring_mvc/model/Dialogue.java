package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "dialogue")
public class Dialogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddialogue")
    private int idDialogue;

    @Column(name = "script")
    private String script;

    @Column(name = "emotion")
    private String emotion;


    @ManyToOne
    @JoinColumn(name = "idscenario")
    private Scenario scenario;

    @ManyToOne
    @JoinColumn(name = "idpersonnage")
    private  Personnage personnage;

    public void setIdDialogue(int idDialogue) {
        this.idDialogue = idDialogue;
    }
    public int getIdDialogue() {
        return idDialogue;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
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
