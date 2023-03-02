package com.pack.spring_mvc.controller;

import com.pack.spring_mvc.model.Films;
import com.pack.spring_mvc.model.Personnage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
public class PersonnageController {

    @GetMapping("/create-personnage")
    public String createPersonnage(Model model, HttpSession session)throws Exception{
        return "create-personnage";
    }

    @PostMapping("/save-personnages")
    public String saveFilms(@RequestParam String [] nom, @RequestParam String [] descriptions, Model model, HttpSession session)throws Exception{
        try{
            System.out.println("Eto "+nom.length);
            return "create-personnage";
        }
        catch (Exception e){
            throw e;
        }
    }
}
