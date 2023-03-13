package com.pack.spring_mvc.model;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
public class PlanningScene {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idplanningscene")
    private Integer idPlanningScene;

    @ManyToOne
    @JoinColumn(name = "idscene")
    private Scene scene;

    @ManyToOne
    @JoinColumn(name = "idplanning")
    private Planning planning;

    @Column( name = "datedebut")
    private LocalDateTime dateDebut;

    @Column( name = "datefin")
    private LocalDateTime dateFin;

    @Column( name = "heureIdeal")
    private Time heureIdeal;

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public void setHeureIdeal(Time heureIdeal) {
        this.heureIdeal = heureIdeal;
    }

    public void setIdPlanningScene(Integer idPlanningScene) {
        this.idPlanningScene = idPlanningScene;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public Integer getIdPlanningScene() {
        return idPlanningScene;
    }

    public Planning getPlanning() {
        return planning;
    }

    public Time getHeureIdeal() {
        return heureIdeal;
    }

    public Scene getScene() {
        return scene;
    }
}
