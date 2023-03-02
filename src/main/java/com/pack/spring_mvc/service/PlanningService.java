package com.pack.spring_mvc.service;


import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.Planning;
import com.pack.spring_mvc.model.TempsTravail;
import com.pack.spring_mvc.model.V_Scenario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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

    private List<V_Scenario>getScenarioByFilm(int idFilm){
        Session sess=dao.getSessionFactory().openSession();
        Criteria critere=sess.createCriteria(V_Scenario.class);
        critere.add(Restrictions.eq("idfilms",idFilm));
        return critere.list();
    }

    private long convertToMillisecond(Time t){
        if(t==null){
            return 0;
        }
        return ((t.getHours()*60*60*1000)+(t.getMinutes()*60*1000)+(t.getSeconds()*1000));
    }

    public List<Planning> getPlanningTemp(List<V_Scenario>allscenario,Time duration,int temjour){
        List<V_Scenario> tempjour=new ArrayList<>();
        long millisecond=0;
        List<Planning> tempplanningjour=new ArrayList<>();
        for(int i=0;i<allscenario.size();i++){
            V_Scenario scenario=(V_Scenario) allscenario.get(i);
            millisecond+=(this.convertToMillisecond(scenario.getDuree()));
            if(scenario.getTempstravail()==temjour){
                System.out.println("millisecond"+millisecond+ "dure"+this.convertToMillisecond(duration));
                if((millisecond>=this.convertToMillisecond(duration))||(((allscenario.size()==(i+1))))){
                    if((millisecond<=this.convertToMillisecond(duration))){
                        tempjour.add(scenario);
                    }
                    if(tempjour.size()>0){
                        V_Scenario[]v_scenarios=new V_Scenario[tempjour.size()];
                        tempplanningjour.add(new Planning(0,temjour,tempjour.toArray(v_scenarios)));
                        tempjour.clear();
                    }
                    if((millisecond>this.convertToMillisecond(duration))){
                        tempjour.add(scenario);
                        if((allscenario.size()==(i+1)||(((V_Scenario)allscenario.get(i+1)).getTempstravail()!=temjour))){
                            V_Scenario[]all=new V_Scenario[tempjour.size()];
                            tempplanningjour.add(new Planning(0,temjour,tempjour.toArray(all)));
                        }
                    }
                    millisecond=0;

                }
                else{
                    tempjour.add(scenario);
                    if((allscenario.size()==(i+1)||(((V_Scenario)allscenario.get(i+1)).getTempstravail()!=temjour))){
                        V_Scenario[]all=new V_Scenario[tempjour.size()];
                        tempplanningjour.add(new Planning(0,temjour,tempjour.toArray(all)));
                    }
                }
            }
        }
        return tempplanningjour;
    }

    public List<List<Planning>>listAllPlan(List<V_Scenario>allscenario,TempsTravail tempsTravail){
        long millisecond=0;
        List<V_Scenario> tempjour=new ArrayList<>();
        List<V_Scenario> tempnuit=new ArrayList<>();
        List<Planning> tempplanningjour=this.getPlanningTemp(allscenario,tempsTravail.getDureejour(),1);
        List<Planning> tempplanningnuit=this.getPlanningTemp(allscenario,tempsTravail.getDureenuit(),2);
        List<List<Planning>>allplanning=new ArrayList<>();
        allplanning.add(tempplanningjour);
        allplanning.add(tempplanningnuit);
        return allplanning;
    }

    public List<List<Planning>> getPlanByFilm(int idFilm){
        TempsTravail temps=dao.findAll(new TempsTravail()).get(0);
        List<V_Scenario>allscenario=this.getScenarioByFilm(idFilm);
        return this.listAllPlan(allscenario,temps);
    }

}
