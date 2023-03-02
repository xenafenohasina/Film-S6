package com.pack.spring_mvc.controller;

import com.pack.spring_mvc.model.V_Scenario;
import com.pack.spring_mvc.service.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class V_ScenarioController {
    @Autowired
    private ScenarioService scenarioService;

    @GetMapping("/list-scenario")
    public String listScenarioByScene(@RequestParam int idScene, @RequestParam int page, Model m){
        try{
            List<V_Scenario> allscenario=scenarioService.getScenarioByScene(idScene,page,4);
            m.addAttribute("allscenario",allscenario);
            m.addAttribute("idScene",idScene);
            return "list-scenario";
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
