package com.remd.remd_annonces.service;

import com.remd.remd_annonces.models.Commentaires;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICommentaireService {
    Commentaires create(Commentaires commentaires);
    Commentaires update(Commentaires commentaires);
    List<Commentaires> getAll();
    ResponseEntity<?> delete(Long id);
    List<Commentaires> findByIdAnnonces(Long idAnnonces);

}
