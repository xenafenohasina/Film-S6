package com.pack.spring_mvc.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "scenario")
public class Scenario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idscenario")
    private int idScenario;

    @Column(name = "duree")
    private Time duree;

    @ManyToOne
    @JoinColumn(name = "idscene")
    private Scene scene;

    @ManyToOne
    @JoinColumn(name = "idtype")
    private Type type;

    @Column(name = "tempstravail")
    private int tempsTravail;

    public int getIdScenario() {
        return idScenario;
    }

    public void setIdScenario(int idScenario) {
        this.idScenario = idScenario;
    }

    public Time getDuree() {
        return duree;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getTempsTravail() {
        return tempsTravail;
    }

    public void setTempsTravail(int tempsTravail) {
        this.tempsTravail = tempsTravail;
    }
}
