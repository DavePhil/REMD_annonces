package com.remd.remd_annonces.controller;

import com.remd.remd_annonces.models.Annonces;
import com.remd.remd_annonces.proxies.ArticleProxy;
import com.remd.remd_annonces.service.impl.AnnoncesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("findbyUserId/{idUser}")
    public List<Annonces> listAnnoncesByUser(@PathVariable("idUser")Long idUser){
        return annoncesServices.findByIdUsers(idUser);
    }
    @GetMapping("findbyNotUserId/{idUser}")
    public List<Annonces> listAnnoncesByNotUser(@PathVariable("idUser")Long idUser){
        return annoncesServices.findByNotIdUsers(idUser);
    }
}
