package com.remd.remd_annonces.repository;

import com.remd.remd_annonces.models.Annonces;
import com.remd.remd_annonces.models.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentairesRepository extends JpaRepository<Commentaires, Long> {

    List<Commentaires> findCommentairesByAnnonces_Id(Long id);
}
