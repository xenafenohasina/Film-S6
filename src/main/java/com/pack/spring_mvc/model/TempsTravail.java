package com.pack.spring_mvc.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class TempsTravail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idtempstravail")
    private Integer idtempstravail;

    @Column(name = "dureejour")
    private Time dureejour;

    @Column(name = "dureenuit")
    private Time dureenuit;

    public Integer getIdtempstravail() {
        return idtempstravail;
    }

    public void setIdtempstravail(Integer idtempstravail) {
        this.idtempstravail = idtempstravail;
    }

    public Time getDureejour() {
        return dureejour;
    }

    public void setDureejour(Time dureejour) {
        this.dureejour = dureejour;
    }

    public Time getDureenuit() {
        return dureenuit;
    }

    public void setDureenuit(Time dureenuit) {
        this.dureenuit = dureenuit;
    }
}
