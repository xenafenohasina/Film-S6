package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
public class V_Dialogue {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "iddialogue")
    private Integer idDialogue;

    @Column( name = "script")
    private String script;

    @Column( name = "emotion")
    private String emotion;

    @Column( name = "idscenario")
    private int idScenario;

    @Column( name = "idpersonnage")
    private int idPersonnage;

    @Column( name = "nom")
    private String nom;

    public Integer getIdDialogue() {
        return idDialogue;
    }

    public void setIdDialogue(Integer idDialogue) {
        this.idDialogue = idDialogue;
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
