package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
public class Scene {

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
