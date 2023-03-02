package com.pack.spring_mvc.model;

import javax.persistence.*;

@Entity
public class ImageFilms {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idimagefilms")
    private Integer idImageFilms;

    @Column( name = "idFilms")
    private Integer idFilms;

    @Column( name = "image")
    private String image;

    public void setIdFilms(Integer idFilms) {
        this.idFilms = idFilms;
    }

    public void setIdImageFilms(Integer idImageFilms) {
        this.idImageFilms = idImageFilms;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIdFilms() {
        return idFilms;
    }

    public Integer getIdImageFilms() {
        return idImageFilms;
    }

    public String getImage() {
        return image;
    }
}
