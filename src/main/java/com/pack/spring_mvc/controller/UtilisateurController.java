package com.pack.spring_mvc.controller;

import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.Films;
import com.pack.spring_mvc.model.Utilisateur;
import com.pack.spring_mvc.model.V_Films;
import com.pack.spring_mvc.service.AuteurService;
import com.pack.spring_mvc.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    HibernateDao dao;

    @Autowired
    AuteurService service;

    @PostMapping("/login")
    public String connecting(@ModelAttribute Utilisateur user, Model model, HttpSession httpSession){
       Utilisateur response = service.checkLogin(user);
        if( response == null ){
            model.addAttribute("error", "Login erronée" );
            return "login";
        }
        httpSession.setAttribute("idUtilisateur", response.getIdutilisateur());
        return home(model, httpSession);
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession httpSession){
        int idUtilisateur = (int)httpSession.getAttribute("idUtilisateur");
        List<V_Films> films = service.filmsHome(idUtilisateur);
        Utilisateur utilisateur = service.findUserSession(idUtilisateur);

        model.addAttribute("utilisateur", utilisateur );
        model.addAttribute("films", films );
        return "listeFilms";
    }

    @GetMapping("/filter")
    public String rechercher(Model model, HttpSession httpSession, Films film){
        int idUtilisateur = (int)httpSession.getAttribute("idUtilisateur");
        List<V_Films> films = service.filmsHome(idUtilisateur);
        Utilisateur utilisateur = service.findUserSession(idUtilisateur);

        model.addAttribute("utilisateur", utilisateur );
        model.addAttribute("films", films );
        return "listeFilms";
    }

 /*   @Autowired
    AdminService adminService;

    @GetMapping("/modifier")
    public String updatePublication(@RequestParam("id") int idPublication, Model model){
        Vpublication vpublication = dao.findById(Vpublication.class, idPublication);
        model.addAttribute("publication", vpublication);
        model.addAttribute("rubriques", dao.findAll(Rubrique.class) );
        model.addAttribute("types", dao.findAll(TypePublication.class) );
        model.addAttribute("lieux", dao.findAll(Lieu.class) );
        model.addAttribute("statuts", dao.findAll(Statut.class) );

        return "admin/updatePublication";
    }

    @PostMapping("/validateUpdate")
    public String updatePublication(@RequestParam("photo") CommonsMultipartFile file, @ModelAttribute Publication publication, Model model, HttpSession session){
        String filePath = session.getServletContext().getRealPath("/image");
        adminService.updatePublication(publication, file.getOriginalFilename());
        service.savePhoto(file, filePath);
        return home(model);
    }

    @PostMapping("/parametrageNombre")
    public String parametrageNombre(@RequestParam("nombre") int nombre, Model model){
        try {
            adminService.parametrageNombre(nombre);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return home(model);
    }

    @GetMapping("/toHomePage")
    public String toHomePage(@RequestParam("id") int idPublication, Model model){
        adminService.toHomePage(idPublication);
        return home(model);
    }

    @PostMapping("/validatePublication")
    public String validatePublication(@RequestParam("id") int publicationID, @RequestParam("datepublication") String datePublication, Model model){
       datePublication = datePublication.replace('T', ' ');
       datePublication += ":00";

        Statut statut = new Statut();
        statut.setCode(1);
        statut = dao.findWhere(statut).get(0);
        Publication publication = new Publication();

        publication.setId(publicationID);
        publication = dao.findById(Publication.class, publicationID);

        Timestamp tm = Timestamp.valueOf(datePublication);
        publication.setDatepublication(tm);
        publication.setStatut(statut);
        dao.update(publication);
        return home(model);
    }

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String connecting(@ModelAttribute Admin admin, Model model){
        List<Admin> response = dao.findWhere(admin);
        if( response.size() == 0 ){
            model.addAttribute("error", "Login erronée" );
            return "admin/login";
        }
        return home(model);
    }

    @GetMapping("/home")
    public String home(Model model){
        int size = adminService.getLastParametrageNombre();
        int offset = 0;
        List<Vpublication> response = dao.paginate(Vpublication.class, offset, size);
        model.addAttribute("publications", response );
        model.addAttribute("pages", dao.findAll(Vpublication.class).size());
        model.addAttribute("size", size);

        return "admin/publicationList";
    }

    @GetMapping("/paginatePublication")
    public String paginatePublication(@RequestParam("page") int page, Model model){
        int size = adminService.getLastParametrageNombre();

        List<Vpublication> response = dao.paginate(Vpublication.class, page, size);
        model.addAttribute("publications", response );
        model.addAttribute("pages", dao.findAll(Vpublication.class).size());
        model.addAttribute("size", size );

        return "admin/publicationList";
    }

    @PostMapping("/filterPublication")
    public String filterPublication(@RequestParam("condition") String condition, @RequestParam(value = "statut", required = false) int[] statut,Model model){
        int size = adminService.getLastParametrageNombre();

        List<Vpublication> response = service.filterPublication(condition, new Vpublication(), statut, size);
        model.addAttribute("publications", response );
        model.addAttribute("pages",response.size());
        model.addAttribute("condition", condition );
        model.addAttribute("size", size );

        return "admin/publicationList";
    }

    @GetMapping("/paginateFilterPublication")
    public String paginateFilterPublication(@RequestParam("condition") String condition, @RequestParam("page") int page, Model model){
        int size = adminService.getLastParametrageNombre();

        List<Vpublication> response = service.paginateFilterPublication(condition, new Vpublication(), page, size);
        model.addAttribute("publications", response );
        model.addAttribute("pages",response.size() );
        model.addAttribute("size", size );
        model.addAttribute("condition", condition );

        return "admin/publicationList";
    } */

}
