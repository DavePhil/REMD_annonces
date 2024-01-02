package com.remd.remd_annonces.service.impl;

import com.remd.remd_annonces.models.Commentaires;
import com.remd.remd_annonces.repository.CommentairesRepository;
import com.remd.remd_annonces.service.ICommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentairesService implements ICommentaireService {
    @Autowired
    private CommentairesRepository commentairesRepository;

    @Override
    public Commentaires create(Commentaires commentaires) {
        return commentairesRepository.save(commentaires);
    }

    @Override
    public Commentaires update(Commentaires commentaires) {
        // code
        return commentairesRepository.save(commentaires);
    }

    public Commentaires _findById(Long id){
        return commentairesRepository.findById(id).get();
    }

    @Override
    public List<Commentaires> getAll() {
        return commentairesRepository.findAll();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Commentaires commentaires = _findById(id);
        if (commentaires== null) return new ResponseEntity<>("Ce commentaire n'existe pas", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(commentaires, HttpStatus.OK);
    }

    @Override
    public List<Commentaires> findByIdAnnonces(Long idAnnonces) {
        return commentairesRepository.findCommentairesByAnnonces_Id(idAnnonces);
    }
}
