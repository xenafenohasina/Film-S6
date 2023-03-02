package com.pack.spring_mvc.service;

import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.Personnage;
import com.pack.spring_mvc.model.Plateau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonnageService {

    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    public List<Personnage> getAll()throws Exception{
        try{
            List <Personnage> listes = dao.findAll(new Personnage());
            return listes;
        }
        catch (Exception e){
            throw e;
        }
    }
    public ArrayList<Personnage> allPersonnage() throws  Exception{
        ArrayList<Personnage> personnages = new ArrayList<Personnage>();

        try{
            personnages = (ArrayList<Personnage>) dao.findAll(new Personnage());
        }
        catch (Exception e){
            throw e;
        }

        return personnages;
    }
}
