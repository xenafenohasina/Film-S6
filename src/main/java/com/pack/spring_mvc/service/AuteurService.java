package com.pack.spring_mvc.service;

import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuteurService {
    @Autowired
    HibernateDao dao;

    int limitSize = 8;

    public String getMd5Hash(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);

            while (hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Utilisateur checkLogin(Utilisateur utilisateur){
        utilisateur.setMotdepasse(getMd5Hash(utilisateur.getMotdepasse()));
        Session session = dao.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("email", utilisateur.getEmail()));
        criteria.add(Restrictions.eq("motdepasse", utilisateur.getMotdepasse()));

        List<Utilisateur> response = criteria.list();
        if( response.size() > 0 ){
            return response.get(0);
        }
        return null;
    }

    public Utilisateur findUserSession(int idUtilisateur){
        Utilisateur response = dao.findById(Utilisateur.class, idUtilisateur);
        return response;
    }

    public <T> List<V_Films> getActeurFilms(int idActeur){
        Session session = dao.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(VPersonnageFilms.class);
        criteria.add(Restrictions.eq("idacteur", idActeur));
        int pageBeginning = 0;

        List<V_Films> results = new ArrayList<V_Films>();
        List<VPersonnageFilms> listes = criteria
                .setFirstResult(pageBeginning)
                .setMaxResults(limitSize)
                .list();
        for( VPersonnageFilms liste: listes ){
            results.add(dao.findById(V_Films.class, liste.getId()));
        }
        return results;
    }

    public <T> List<V_Films> filmsHome(int idUtilisateur){
        Utilisateur identification = findUserSession(idUtilisateur);
        int pageBeginning = 0;
        if( identification.getIdrole() == 1 ){
            V_Films v_films = new V_Films();
            return dao.paginateWhere(v_films, pageBeginning, limitSize);
        }
        else if( identification.getIdrole() == 2 ){
            V_Films films = new V_Films();
            films.setIdUtilisateur(idUtilisateur);
            return dao.paginateWhere(films, pageBeginning, limitSize);
        }
        else if( identification.getIdrole() == 3 ){
            return getActeurFilms(idUtilisateur);
        }
        return null;
    }


/*    public <T> List<Vpublication> filterPublication(String condition, T entity, int size){
        String query = "where (lower(titre) like lower('%"+condition+"%')) or (lower(body) like lower('%"+condition+"%'))";
        List<Vpublication> response = dao.paginateWhere( new Vpublication(), 0, size, query);
        return response;
    }

    public void updatePublication(Publication publication, String coverPhoto){
        Publication beforeObject = dao.findById(Publication.class, publication.getId());
        publication.setDatecreation(beforeObject.getDatecreation());
        publication.setAuteur(beforeObject.getAuteur());

        if( publication.getTypepublicationid() == 1 ){
            publication.setDatefin(null);
        }

        System.out.println("photo kely "+coverPhoto.trim().length());
        if( coverPhoto.trim().length() == 0 ){
            publication.setPhotocouverture(beforeObject.getPhotocouverture());
        } else{
            publication.setPhotocouverture(coverPhoto);
        }

        if( publication.getStatutCode() == 0 ){
            publication.setDatepublication(null);
        }
        Rubrique rubrique = new Rubrique();
        rubrique.setId(publication.getRubrique());
        Statut st = new Statut();
        st.setCode(publication.getStatutCode());
        st = dao.findWhere(st).get(0);

        publication.setStatut(st);
        publication.setRubriqueid(rubrique);
        dao.update(publication);
    }

    public void parametrageNombre(int nombre) throws Exception{
        if( nombre <= 0 ){
            throw new Exception("Nombre <= 0 invalide");
        }

        long lnow = System.currentTimeMillis();
        Date now = new Date(lnow);

        HomePageNumber homePageNumber = new HomePageNumber();
        homePageNumber.setNombre(nombre);
        homePageNumber.setDateParametrage(now);

        dao.create(homePageNumber);
    }

    public int getLastParametrageNombre(){
        Session session = dao.getSessionFactory().openSession();
        Order order = Order.desc("id");

        List<HomePageNumber> results = session.createCriteria(HomePageNumber.class)
                .addOrder(order)
                .setMaxResults(1)
                .list();
        session.close();
        HomePageNumber last = results.get(0);

        return last.getNombre();
    }

    public void toHomePage(int idPublication){
        Publication publication = dao.findById(Publication.class, idPublication);
        publication.setIsHomePage(1);

        dao.update(publication);
    } */
}
