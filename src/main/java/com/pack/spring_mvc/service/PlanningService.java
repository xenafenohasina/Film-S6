package com.pack.spring_mvc.service;

import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.Planning;
import com.pack.spring_mvc.model.PlanningPlateau;
import com.pack.spring_mvc.model.Plateau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class PlanningService {

    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    public Planning createPlanning(Planning planning)throws Exception{
        try{
            Planning p = dao.create(planning);
            return p;
        }
        catch (Exception e){
            throw e;
        }
    }

    public void createPlanningPlateau(Planning planning, int [] idPlateau, String [] heureDebut, String [] heureFin){
        for(int i=0; i<idPlateau.length; i++){
            PlanningPlateau p = new PlanningPlateau();
            Plateau plateau = dao.findById(Plateau.class,idPlateau[i]);
            p.setPlanning(planning);
            p.setPlateau(plateau);
            p.setHeureDebut(Time.valueOf(heureDebut[i]));
            p.setHeureFin(Time.valueOf(heureFin[i]));

        }
    }
}
