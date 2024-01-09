package com.remd.remd_annonces.service.impl;

import com.remd.remd_annonces.models.Annonces;
import com.remd.remd_annonces.proxies.ArticleProxy;
import com.remd.remd_annonces.repository.AnnoncesRepository;
import com.remd.remd_annonces.service.IAnnoncesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnoncesServices implements IAnnoncesService {
    @Autowired
    private AnnoncesRepository annoncesRepository;


    @Override
    public Annonces create(Annonces annonces) {

        return annoncesRepository.save(annonces);
    }

    public Annonces _findById(Long id){
        return annoncesRepository.findById(id).get();
    }

    @Override
    public Annonces update(Annonces annonces) {

        return annoncesRepository.save(annonces);
    }
    public List<Annonces> findByIdUsers(Long idUsers){
        return annoncesRepository.findByIdUsers(idUsers);

    }
    public List<Annonces> findByNotIdUsers(Long idUsers){
        return annoncesRepository.findByNotIdUsers(idUsers);
    }

    @Override
    public List<Annonces> getAll() {
        return annoncesRepository.findAll();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Annonces annonces = _findById(id);
        if (annonces==null) return new ResponseEntity<>("Cette annonce n'existe pas", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(annonces,HttpStatus.OK);

    }

    public Annonces create(String titre, String localisation, String date, Long idArticle, Long idUser) {
        Annonces annonces = new Annonces();
        annonces.setDate(date);
        annonces.setLocalisation(localisation);
        annonces.setTitre(titre);
        annonces.setIdArticle(idArticle);
        annonces.setIdUsers(idUser);
        return annoncesRepository.save(annonces);
    }
}
