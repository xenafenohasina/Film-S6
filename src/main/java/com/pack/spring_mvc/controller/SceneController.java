package com.pack.spring_mvc.controller;

import com.pack.spring_mvc.model.Films;
import com.pack.spring_mvc.model.Plateau;
import com.pack.spring_mvc.model.Scene;
import com.pack.spring_mvc.model.V_Scene;
import com.pack.spring_mvc.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @GetMapping("/update-scene")
    public String updateFilms(@RequestParam int idScene, Model model, HttpSession session)throws Exception{
        try{
            Scene scene = sceneService.getScene(idScene);
            model.addAttribute("scene",scene);
            return "update-scene";
        }
        catch (Exception e){
            throw e;
        }
    }

    @PostMapping("/modifier-scene")
    public String modifierScene(@ModelAttribute Scene scene, Model model, HttpSession session)throws Exception{
        try{
            Scene scene1 = sceneService.updateScene(scene);
            model.addAttribute("scene",scene1);
            return "update-scene";
        }
        catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/form-scene")
    public String formScene(Model m){
        m.addAttribute("allplateau",sceneService.getDao().findAll(new Plateau()));
        return "form-scene";
    }

    @PostMapping("/save-scene")
    public String saveScene(@ModelAttribute Scene scene,@RequestParam int page){
        try {
            sceneService.saveScene(scene);
            return "redirect:list-scene?idFilm="+scene.getIdFilms()+"&page="+page;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:form-scene";
    }

    @GetMapping("/list-scene")
    public String listSceneByFilm(@RequestParam int idFilm,@RequestParam int page,Model m){
        try{
            List<V_Scene> allscene=sceneService.paginateScene(idFilm,page,4);
            m.addAttribute("allscene",allscene);
            m.addAttribute("allplateau",sceneService.getDao().findAll(new Plateau()));
            m.addAttribute("countpage",sceneService.getDao().countPaginationAll(allscene,4));
            return "list-scene";
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }


}
