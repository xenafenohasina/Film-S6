package com.pack.spring_mvc.model;

import com.pack.spring_mvc.dao.HibernateDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class V_Scenario {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "idscenario")
    private Integer idScenario;
    @Column( name = "duree")
    private Time duree;

    @Column( name = "idscene")
    private int idscene;

    @Column( name = "idtype")
    private int idtype;

    @Column( name = "nomtype")
    private String nomtype;

    @Transient
    private List details;

    @Column( name = "tempstravail")
    private int tempstravail;

    @Column( name = "idfilms")
    private int idfilms;

    public List getDetails() {
        return details;
    }

    public void setDetails(List details) {
        this.details = details;
    }

    public Integer getIdScenario() {
        return idScenario;
    }

    public void setIdScenario(Integer idScenario) {
        this.idScenario = idScenario;
    }

    public Time getDuree() {
        return duree;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public int getIdscene() {
        return idscene;
    }

    public void setIdscene(int idscene) {
        this.idscene = idscene;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public String getNomtype() {
        return nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }

    public void setIdfilms(int idfilms) {
        this.idfilms = idfilms;
    }

    public void setTempstravail(int tempstravail) {
        this.tempstravail = tempstravail;
    }

    public int getTempstravail() {
        return tempstravail;
    }

    public int getIdfilms() {
        return idfilms;
    }

    public String getTemps(){
        if( this.getTempstravail() == 1 ){
            return "Jour";
        }
        return "Nuit";
    }
}
