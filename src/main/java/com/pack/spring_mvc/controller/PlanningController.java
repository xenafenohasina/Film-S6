package com.pack.spring_mvc.controller;

import com.pack.spring_mvc.model.Planning;
import com.pack.spring_mvc.model.Utilisateur;
import com.pack.spring_mvc.model.V_Films;
import com.pack.spring_mvc.model.V_Scenario;
import com.pack.spring_mvc.service.AuteurService;
import com.pack.spring_mvc.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PlanningController {
    @Autowired
    PlanningService planningService;

    @Autowired
    AuteurService service;

    @GetMapping("/list-planning")
    public String listPlanningByFilm(@RequestParam int idFilm, Model m, HttpSession httpSession){
        try{
            int idUtilisateur = (int)httpSession.getAttribute("idUtilisateur");
            Utilisateur utilisateur = service.findUserSession(idUtilisateur);

            m.addAttribute("utilisateur", utilisateur );
            List<List<Planning>> allplanning=planningService.getPlanByFilm(idFilm);
            m.addAttribute("allplanning",allplanning);
            return "list-planning";
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
