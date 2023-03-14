package com.pack.spring_mvc.service;

import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.Personnage;
import com.pack.spring_mvc.model.Plateau;
import com.pack.spring_mvc.model.Statut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlateauService {

    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    public List<Plateau> getAll()throws Exception{
        try{
            List <Plateau> listes = dao.findAll(new Plateau());
            return listes;
        }
        catch (Exception e){
            throw e;
        }
    }

    public ArrayList<Plateau> allPlateau() throws  Exception{
        ArrayList<Plateau> plateaus = new ArrayList<Plateau>();

        try{
            plateaus = (ArrayList<Plateau>) dao.findAll(new Plateau());
        }
        catch (Exception e){
            throw e;
        }

        return plateaus;
    }

}
