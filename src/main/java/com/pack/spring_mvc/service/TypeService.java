package com.pack.spring_mvc.service;

import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TypeService {
    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    public ArrayList<Type> allType() throws  Exception{
        ArrayList<Type> types = new ArrayList<Type>();

        try{
           types = (ArrayList<Type>) dao.findAll(new Type());
        }
        catch (Exception e){
            throw e;
        }

        return types;
    }
}
