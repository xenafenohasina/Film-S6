package com.pack.spring_mvc.model;

public class Temps {

    Integer idTemps;
    String temps;

    public void setIdTemps(Integer idTemps) {
        this.idTemps = idTemps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public Integer getIdTemps() {
        return idTemps;
    }

    public String getTemps() {
        return temps;
    }

    public Temps(Integer idTemps, String temps){
        this.idTemps = idTemps;
        this.temps = temps;
    }
}
