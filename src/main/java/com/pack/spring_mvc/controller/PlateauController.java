package com.pack.spring_mvc.controller;

import com.pack.spring_mvc.model.*;
import com.pack.spring_mvc.service.PlateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PlateauController {

    @Autowired
    PlateauService plateauService;


    @GetMapping("/create-planning")
    public String createPlanning(Model model, HttpSession session)throws Exception{
        return "create-planning";
    }


    @GetMapping("/form-planning")
    public String listPlateau(Model m) throws Exception{
        try{
            ArrayList<Plateau> plateaus= plateauService.allPlateau();

            m.addAttribute("plateaus",plateaus);

        }
        catch (Exception ex){
            throw ex;
        }
        return "create-planning";
    }

}
