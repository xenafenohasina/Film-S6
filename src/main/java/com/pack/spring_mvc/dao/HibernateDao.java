package com.pack.spring_mvc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class HibernateDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> T create(T entity){
        Session session = null;
        Transaction transaction = null;
        try{
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( transaction.isActive() ){
                transaction.rollback();
            }
            if( session != null ){
                session.close();
            }
        }
        return entity;
    }

    public void delete(Object entity){
        Session session = null;
        Transaction transaction = null;
        try{
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( transaction.isActive() ){
                transaction.rollback();
            }
            if( session != null ){
                session.close();
            }
        }
    }

    public <T> T update(T entity){
        Session session = null;
        Transaction transaction = null;
        try{
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( transaction.isActive() ){
                transaction.rollback();
            }
            if( session != null ){
                session.close();
            }
        }
        return entity;
    }

    public <T> List<T> findWhere(T entity){
        Session session = sessionFactory.openSession();
        Example example = Example.create(entity).ignoreCase();
        List<T> results = session.createCriteria(entity.getClass()).add(example).list();
        session.close();
        return results;
    }


    public <T> T findById(Class<T> clazz, Serializable id){
        Session session = sessionFactory.openSession();
        T entity = (T) session.get(clazz, id);
        session.close();
        return entity;
    }

    public <T> List<T> findAll(Class<T> tClass){
        Session session = this.getSessionFactory().openSession();
        List<T> results = session.createCriteria(tClass).list();
        session.close();
        return results;
    }

    public <T> List<T> findAll(T entity){
        Session session = null;
        List <T> list = null;
        try{
            session = this.sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            list = session.createCriteria(entity.getClass()).add(example).list();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return list;
    }

    public <T> List<T> paginate(T entity, int offset, int limit){
        Session session = null;
        List <T> list = null;
        try{
            session = this.sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            list = session.createCriteria(entity.getClass())
                    .add(example)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .list();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return list;
    }

    public <T> List<T> findPaginate(T entity, int offset, int limit, String mot){
        Session session = null;
        List <T> list = null;
        try{
            session = this.sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            list = session.createCriteria(entity.getClass())
                    .add(example)
                    .add(
                            Restrictions.or(
                                    Restrictions.ilike("nom", mot, MatchMode.ANYWHERE),
                                    Restrictions.ilike("descriptions", mot, MatchMode.ANYWHERE)
                            )
                    )
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .list();
            ;
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return list;
    }

    // use for admins
    public <T> List<T> findRecherche(T entity, String mot){
        Session session = null;
        List <T> list = null;
        try{
            session = this.sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            list = session.createCriteria(entity.getClass())
                    .add(example)
                    .add(
                            Restrictions.or(
                                    Restrictions.ilike("nom", mot, MatchMode.ANYWHERE),
                                    Restrictions.ilike("descriptions", mot, MatchMode.ANYWHERE)
                            )
                    ).list();
            ;
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return list;
    }

    public <T> List<T> paginateWhere (T entity, int offset, int limit){
        Session session = null;
        List <T> list = null;
        try{
            session = this.sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            list = session.createCriteria(entity.getClass())
                    .add(example)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .list();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return list;
    }



    public <T> List<T> paginateUser(T entity, int offset, int limit){
        Session session = null;
        List <T> list = null;
        try{
            session = this.sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            list = session.createCriteria(entity.getClass())
                    .add(example)
                    .add(
                            Restrictions.le("dateDePublication", LocalDateTime.now())
                    )
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .list();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return list;
    }

    public <T> List<T> allUser(T entity){
        Session session = null;
        List <T> list = null;
        try{
            session = this.sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            list = session.createCriteria(entity.getClass())
                    .add(example)
                    .add(
                            Restrictions.le("dateDePublication", LocalDateTime.now())
                    )
                    .list();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return list;
    }

    public double getTotalPagination(int size,int nbpage){
        double sz=((double)size)/((double)nbpage);
        double totruenb=(double)((int)sz);
        if(sz>totruenb){
            totruenb+=1.0;
        }
        return totruenb;
    }

    public <T> int countPaginationAll(List<T>results,int size){
        int page=(int)getTotalPagination(results.size(),size);
        return page;
    }

    public <T> List<T> findPaginateUser(T entity, int offset, int limit, String mot){
        Session session = null;
        List <T> list = null;
        try{
            session = this.sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            list = session.createCriteria(entity.getClass())
                    .add(example)
                    .add(Restrictions.le("dateDePublication",LocalDateTime.now()))
                    .add(
                            Restrictions.or(
                                    Restrictions.ilike("nom", mot, MatchMode.ANYWHERE),
                                    Restrictions.ilike("descriptions", mot, MatchMode.ANYWHERE)
                            )
                    )
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .list();
            ;
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return list;
    }

    public <T> List<T> findPaginateUserCount(T entity, String mot){
        Session session = null;
        List <T> list = null;
        try{
            session = this.sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            list = session.createCriteria(entity.getClass())
                    .add(example)
                    .add(Restrictions.le("dateDePublication",LocalDateTime.now()))
                    .add(
                            Restrictions.or(
                                    Restrictions.ilike("nom", mot, MatchMode.ANYWHERE),
                                    Restrictions.ilike("descriptions", mot, MatchMode.ANYWHERE)
                            )
                    )
                    .list();
            ;
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if( session != null ){
                session.close();
            }
        }
        return list;
    }

}
