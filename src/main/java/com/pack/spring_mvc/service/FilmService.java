package com.pack.spring_mvc.service;

import com.pack.spring_mvc.dao.HibernateDao;
import com.pack.spring_mvc.model.Films;
import com.pack.spring_mvc.model.ImageFilms;
import com.pack.spring_mvc.model.Personnage;
import com.pack.spring_mvc.model.V_Films;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.time.LocalDate;

@Service
public class FilmService {

    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    public void createImage(MultipartFile [] files, Films films, String path)throws Exception{
        try{
            for (MultipartFile file : files) {
                if (!file.getOriginalFilename().isEmpty())
                {
                    BufferedOutputStream outputStream = new BufferedOutputStream(
                            new FileOutputStream(new File(path, file.getOriginalFilename()))
                    );
                    outputStream.write(file.getBytes());
                    outputStream.flush();
                    outputStream.close();
                    ImageFilms img = new ImageFilms();
                    img.setIdFilms(films.getIdFilms());
                    img.setImage(file.getOriginalFilename());
                    dao.create(img);
                }
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public void createFilms(Films films, MultipartFile [] files, String path, String [] nomPers, String [] descPers)throws Exception{
        try{
            films.setIdStatut(1);
            films.setDateCreation(Date.valueOf(LocalDate.now()));
            Films f = dao.create(films);
            if( nomPers != null ){
                for(int i=0; i<nomPers.length; i++){
                    Personnage p = new Personnage();
                    p.setIdFilms(f.getIdFilms());
                    p.setNom(nomPers[i]);
                    p.setDescriptions(descPers[i]);
                    dao.create(p);
                }
            }
            this.createImage(files, f, path);
        }
        catch (Exception e){
            throw e;
        }
    }

    public Films updateFilms(Films films)throws Exception{
        try{
            Films f = dao.findById(Films.class, films.getIdFilms());
            f.setNom(films.getNom());
            f.setDateCreation(films.getDateCreation());
            f.setIdStatut(films.getIdStatut());
            Films f1 = dao.update(f);
            return f1;
        }
        catch (Exception e){
            throw e;
        }
    }

    public V_Films getFilms(int idFilms)throws Exception{
        try{
            V_Films f = dao.findById(V_Films.class, idFilms);
            return f;
        }
        catch (Exception e){
            throw new Exception("Film innexistant");
        }
    }
}
