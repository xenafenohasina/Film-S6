package com.pack.spring_mvc.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Planning {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idplanning")
    private Integer idPlanning;

    @Column( name = "datedebut")
    private LocalDateTime dateDebut;

    @Column( name = "datefin")
    private LocalDateTime dateFin;

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setIdPlanning(Integer idPlanning) {
        this.idPlanning = idPlanning;
    }

    public Integer getIdPlanning() {
        return idPlanning;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }
}
