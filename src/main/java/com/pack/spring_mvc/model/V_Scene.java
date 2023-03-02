package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
public class V_Scene {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idscene")
    private Integer idScene;

    @Column( name = "titre")
    private String titre;

    @Column( name = "idplateau")
    private Integer idPlateau;


    @Column( name = "idfilms")
    private Integer idFilms;

    @Column( name = "nomfilm")
    private String nomfilm;

    @Column( name = "nomplateau")
    private String nomplateau;

    public String getNomfilm() {
        return nomfilm;
    }

    public void setNomfilm(String nomfilm) {
        this.nomfilm = nomfilm;
    }

    public String getNomplateau() {
        return nomplateau;
    }

    public void setNomplateau(String nomplateau) {
        this.nomplateau = nomplateau;
    }

    public Integer getIdFilms() {
        return idFilms;
    }

    public void setIdFilms(Integer idFilms) {
        this.idFilms = idFilms;
    }

    public void setIdPlateau(Integer idPlateau) {
        this.idPlateau = idPlateau;
    }

    public void setIdScene(Integer idScene) {
        this.idScene = idScene;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getIdPlateau() {
        return idPlateau;
    }

    public Integer getIdScene() {
        return idScene;
    }

    public String getTitre() {
        return titre;
    }
}
