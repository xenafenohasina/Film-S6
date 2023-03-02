package com.pack.spring_mvc.service;

import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ScenarioService {
    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    public List<V_Scenario> getScenarioByScene(int idScene, int offset, int limit){
        Session sess=dao.getSessionFactory().openSession();
        Criteria critere=sess.createCriteria(V_Scenario.class);
        critere.add(Restrictions.eq("idscene",idScene));
        critere.setFirstResult(offset*limit);
        critere.setMaxResults(limit);
        List<V_Scenario>mylist=critere.list();
        this.defineDetailOfList(mylist);
        sess.close();
        return mylist;
    }

    public void defineDetailOfList(List<V_Scenario>lsscenario){
        for(V_Scenario scenario:lsscenario){
            scenario.setDetails(this.allDetails(scenario));
        }
    }

    public List<?> allDetails(V_Scenario scenario){
        Class<?>myclass= V_Dialogue.class;
        if(scenario.getNomtype().equals("Action")){
            myclass= V_Action.class;
        }
        Session sess=dao.getSessionFactory().openSession();
        Criteria critere=sess.createCriteria(myclass);
        critere.add(Restrictions.eq("idScenario",scenario.getIdScenario()));
        List<?>mylist=critere.list();
        sess.close();
        return mylist;
    }

    public V_Scenario getScenario(int idScenario)throws Exception{
        try{
            V_Scenario scenario = dao.findById(V_Scenario.class, idScenario);
            return scenario;
        }
        catch (Exception e){
            throw new Exception("Scénario inexistant");
        }
    }

    public void deleteScenario(int idScenario)throws Exception{
        try{
            Scenario scenario = dao.findById(Scenario.class, idScenario);
            if( scenario.getType().getNom().equals("Action")){
                List<Action> actions = this.getAllActionByScenario(idScenario);
                this.deleteActionForScenario(actions);
            }
            else{
                List<Dialogue> dialogues = this.getAllDialogueByScenario(idScenario);
                this.deleteDialogueForScenario(dialogues);
            }
            dao.delete(scenario);
        }
        catch (Exception e){
            throw new Exception("Scénario inexistant");
        }
    }

    public List<Action> getAllActionByScenario(int idScenario){
        try{
            Action a = new Action();
            a.setScenario(new Scenario());
            a.getScenario().setIdScenario(idScenario);
            List<Action> listes = dao.findAll(a);
            return listes;
        }
        catch (Exception e){
            throw e;
        }
    }

    public List<Dialogue> getAllDialogueByScenario(int idScenario){
        try{
            Dialogue d = new Dialogue();
            d.setScenario(new Scenario());
            d.getScenario().setIdScenario(idScenario);
            List<Dialogue> listes = dao.findAll(d);
            return listes;
        }
        catch (Exception e){
            throw e;
        }
    }

    public void deleteActionForScenario(List <Action> actions)throws Exception{
        try{
            for( Action a : actions ){
                dao.delete(a);
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public void deleteDialogueForScenario(List <Dialogue> dialogues)throws Exception{
        try{
            for( Dialogue d : dialogues ){
                dao.delete(d);
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public void modifierAction(Scenario scenario, String [] idAction, String [] idPersonnages, String [] descriptions)throws Exception{
        try{
            Scenario s = dao.findById(Scenario.class, scenario.getIdScenario());
            s.setDuree(scenario.getDuree());

            dao.update(s);
            for(int i=0; i<idAction.length; i++){
                Action a = dao.findById(Action.class, Integer.parseInt(idAction[i]));
                Personnage p = dao.findById(Personnage.class, Integer.parseInt(idPersonnages[i]));
                a.setPersonnage(p);
                a.setDescriptions(descriptions[i]);
                dao.update(a);
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public void modifierDialogue(Scenario scenario, String [] idDialogue, String [] idPersonnages, String [] script, String [] emotion)throws Exception{
        try{
            Scenario s = dao.findById(Scenario.class, scenario.getIdScenario());
            s.setDuree(scenario.getDuree());
            dao.update(s);
            for(int i=0; i<idDialogue.length; i++){
                Dialogue d = dao.findById(Dialogue.class, Integer.parseInt(idDialogue[i]));
                Personnage p = dao.findById(Personnage.class, Integer.parseInt(idPersonnages[i]));
                d.setPersonnage(p);
                d.setScript(script[i]);
                d.setEmotion(emotion[i]);
                dao.update(d);
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public void createScenario(Scenario scenario)throws Exception{
        try{
            dao.create(scenario);
            System.out.println(scenario.getIdScenario());
        }
        catch (Exception e){
            throw e;
        }
    }

}
