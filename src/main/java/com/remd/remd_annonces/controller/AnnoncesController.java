package com.remd.remd_annonces.controller;

import com.remd.remd_annonces.Beans.Article;
import com.remd.remd_annonces.models.Annonces;
import com.remd.remd_annonces.proxies.ArticleProxy;
import com.remd.remd_annonces.service.impl.AnnoncesServices;
import com.sun.jdi.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("annonces/")
public class AnnoncesController {

    @Autowired
    private AnnoncesServices annoncesServices;
    @Autowired
    private ArticleProxy articleProxy;
    @PostMapping("create")
    public ResponseEntity<?> create (@RequestBody Annonces annonces){
        articleProxy.marquerPerdu(annonces.getIdArticle());
        Annonces _annonces = annoncesServices.create(annonces);
        return new ResponseEntity<>(_annonces, HttpStatus.OK);
    }
    @PostMapping("createWithArticle")
    public ResponseEntity<?> create(@RequestParam("nom") String nom, @RequestParam("photo")MultipartFile photo,
                                    @RequestParam("description")String description , @RequestParam("titre") String titre,
                                    @RequestParam("localisation") String localisation, @RequestParam("date") String date,
                                    @RequestParam("idUser") Long idUser){
        ResponseEntity<?> article;
        try {
            article = articleProxy.create(nom, photo, description, idUser);
            if (article.getStatusCode()==HttpStatus.OK){
                LinkedHashMap<String,?> _article = (LinkedHashMap<String, ?>) article.getBody();
                Long _idArticle = Long.valueOf((Integer) _article.get("id"));
                Long _idUser = Long.valueOf((Integer) _article.get("idUser"));
                annoncesServices.create(titre,localisation,date, _idArticle, _idUser);
                articleProxy.marquerPerdu(_idArticle);
            }
            return article;
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>("Une erreur est survenue", HttpStatus.BAD_REQUEST);
    }
    ResponseEntity<?> _constructResponse(List<Annonces> annonces){
        List<Map<String,Object>> _annonces = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        for (Annonces annonce : annonces){
            Article article = articleProxy.findById(annonce.getIdArticle());
            map.put("annonces", annonce);
            map.put("article",article);
            _annonces.add(map);
        }
        return new ResponseEntity<>(_annonces,HttpStatus.OK);
    }
    @GetMapping("findbyUserId/{idUser}")
    public ResponseEntity<?> listAnnoncesByUser(@PathVariable("idUser")Long idUser){
        List<Annonces> annonces = annoncesServices.findByIdUsers(idUser);
        ResponseEntity<?> response = _constructResponse(annonces);
        return response;
    }
    @GetMapping("all")
    public List<Annonces> listAnnonces(){
        return annoncesServices.getAll();
    }
    @GetMapping("findbyNotUserId/{idUser}")
    public ResponseEntity<?> listAnnoncesByNotUser(@PathVariable("idUser")Long idUser){
        List<Annonces> annonces = annoncesServices.findByNotIdUsers(idUser);
        ResponseEntity<?> response = _constructResponse(annonces);
        return response;
    }


}
