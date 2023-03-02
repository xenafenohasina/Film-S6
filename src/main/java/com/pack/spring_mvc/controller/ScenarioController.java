package com.pack.spring_mvc.controller;

import com.pack.spring_mvc.model.*;
import com.pack.spring_mvc.service.*;
import org.hibernate.hql.spi.id.cte.AbstractCteValuesListBulkIdHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ScenarioController {

    @Autowired
    ScenarioService scenarioService;

    @Autowired
    ActionService actionService;

    @Autowired
    DialogueService dialogueService;

    @Autowired
    TypeService typeService;

    @Autowired
    PersonnageService personnageService;

    @Autowired
    AuteurService service;

    private Temps [] temps = {new Temps(1,"Jour"),new Temps(2,"Nuit")};

    public Temps[] getTemps() {
        return temps;
    }

    @GetMapping("/delete-scenario")
    public String deleteScenario(@RequestParam int idScenario, Model model)throws Exception{
        try{
            scenarioService.deleteScenario(idScenario);
            return "liste-scenario";
        }
        catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/update-scenario")
    public String updateScenario(@RequestParam int idScenario, Model model)throws Exception{
        try{
            V_Scenario scenario = scenarioService.getScenario(idScenario);
            List<?> listes = scenarioService.allDetails(scenario);
            Utilisateur user = new Utilisateur();
            user.setIdrole(1);
            List<Personnage> personnages = personnageService.getAll();
            model.addAttribute("temps", temps);
            model.addAttribute("personnages", personnages);
            model.addAttribute("user", user);
            model.addAttribute("scenario", scenario);
            model.addAttribute("listes", listes);
            return "update-scenario";
        }
        catch (Exception e){
            throw e;
        }
    }

    @PostMapping("update-action")
    public String updateAction(@ModelAttribute Scenario scenario, @RequestParam String [] idAction,@RequestParam String [] idPersonnage,@RequestParam String [] descriptions, Model model)throws Exception{
        try{
            scenarioService.modifierAction(scenario, idAction, idPersonnage, descriptions);
            V_Scenario s = scenarioService.getScenario(scenario.getIdScenario());
            List<?> listes = scenarioService.allDetails(s);
            Utilisateur user = new Utilisateur();
            user.setIdrole(1);
            List<Personnage> personnages = personnageService.getAll();
            model.addAttribute("temps", temps);
            model.addAttribute("personnages", personnages);
            model.addAttribute("user", user);
            model.addAttribute("scenario", s);
            model.addAttribute("listes", listes);
            return "update-scenario";
        }
        catch (Exception e){
            throw e;
        }
    }

    @PostMapping("update-dialogue")
    public String updateDialogue(@ModelAttribute Scenario scenario, String [] idDialogue, String [] idPersonnage, String [] script, String [] emotion, Model model)throws Exception{
        try{
            scenarioService.modifierDialogue(scenario, idDialogue, idPersonnage, script, emotion);
            V_Scenario s = scenarioService.getScenario(scenario.getIdScenario());
            List<?> listes = scenarioService.allDetails(s);
            Utilisateur user = new Utilisateur();
            user.setIdrole(1);
            List<Personnage> personnages = personnageService.getAll();
            model.addAttribute("temps", temps);
            model.addAttribute("personnages", personnages);
            model.addAttribute("user", user);
            model.addAttribute("scenario", s);
            model.addAttribute("listes", listes);
            return "update-scenario";
        }
        catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/create-scenario")
    public String formScenario(@RequestParam int idScene, Model m, HttpSession httpSession) throws Exception{
        try{

            int idUtilisateur = (int)httpSession.getAttribute("idUtilisateur");
            List<V_Films> films = service.filmsHome(idUtilisateur);
            Utilisateur utilisateur = service.findUserSession(idUtilisateur);

            m.addAttribute("utilisateur", utilisateur );
            m.addAttribute("films", films );
        //    return "listeFilms";

            ArrayList<Type> types= typeService.allType();
            ArrayList<Personnage> personnages = personnageService.allPersonnage();

            m.addAttribute("types",types);
            m.addAttribute("personnages",personnages);
            m.addAttribute("idScene",idScene);

        }
        catch (Exception ex){
            throw ex;
        }
        return "create-scenario";
    }

    @PostMapping("/save-scenario")
    public String saveScenario(@RequestParam(required = false) int idScene, @RequestParam(required = false) String[] idType, @RequestParam(required = false) String[] idPersonnage, @RequestParam(required = false) String[] description, @RequestParam(required = false) String[] script, @RequestParam(required = false) String[] emotion, HttpSession session)throws Exception{
        try{
            int[] idPersonnages = new int[idPersonnage.length];
            Personnage personnage = new Personnage();

            int idTypes = Integer.parseInt(idType[0]);
            Type t = new Type();
            t.setIdType(idTypes);

            // int idScenes = Integer.parseInt(idScene);
            Scene scene = new Scene();
            scene.setIdScene(idScene);

            Scenario scenario = new Scenario();
            scenario.setType(t);
            scenario.setScene(scene);

            //insertion scenario
            scenarioService.createScenario(scenario);

            System.out.println(scenario.getIdScenario());

            for (int i = 0; i < idPersonnage.length; i++) {
                idPersonnages[i] = Integer.parseInt(idPersonnage[i]);
            }

            if (description != null) {
                Action action = new Action();
                action.setScenario(scenario);

                for (int i = 0; i < description.length; i++) {
                    action.setDescriptions(description[i]);

                    personnage.setIdPersonnage(idPersonnages[i]);
                    action.setPersonnage(personnage);

                    actionService.createAction(action);
                }

                System.out.println(idTypes);
            }

            if (script != null){

                Dialogue dialogue = new Dialogue();
                dialogue.setScenario(scenario);

                for (int i = 0; i < script.length; i++) {
                    dialogue.setScript(script[i]);
                    dialogue.setEmotion(emotion[i]);

                    personnage.setIdPersonnage(idPersonnages[i]);
                    dialogue.setPersonnage(personnage);

                    dialogueService.createDialogue(dialogue);

                }

            }
            return "redirect:list-scenario?idScene="+idScene+"&page=0";
        }
        catch (Exception e){
            throw e;
        }
    }



}
