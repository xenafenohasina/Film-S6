package com.pack.spring_mvc.service;

import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.Films;
import com.pack.spring_mvc.model.Scene;
import com.pack.spring_mvc.model.V_Scene;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneService {


    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }


    public void saveScene(Scene scene){
        try{
            System.out.println("scene"+scene.getTitre());
            dao.update(scene);
        }
        catch (Exception ex){
            throw ex;
        }
    }

    public List<V_Scene> paginateScene(int idFilm, int offset, int limit){
        Session sess=dao.getSessionFactory().openSession();
        Criteria critere=sess.createCriteria(V_Scene.class);
        critere.add(Restrictions.eq("idFilms",idFilm));
        critere.setFirstResult(offset*limit);
        critere.setMaxResults(limit);
        List<V_Scene>vscene=critere.list();
        sess.close();
        return vscene;
    }

    public Scene updateScene(Scene scene)throws Exception{
        try{
            Scene s = dao.findById(Scene.class, scene.getIdScene());
            s.setTitre(scene.getTitre());
            s.setIdPlateau(scene.getIdPlateau());
            Scene s1 = dao.update(s);
            return s1;
        }
        catch (Exception e){
            throw e;
        }
    }

    public Scene getScene(int idScene)throws Exception{
        try{
            Scene f = dao.findById(Scene.class, idScene);
            return f;
        }
        catch (Exception e){
            throw new Exception("Scene innexistant");
        }
    }
}
