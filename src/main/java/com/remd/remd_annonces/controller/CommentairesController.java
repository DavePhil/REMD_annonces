package com.remd.remd_annonces.controller;

import com.remd.remd_annonces.Beans.Users;
import com.remd.remd_annonces.models.Commentaires;
import com.remd.remd_annonces.proxies.UserProxy;
import com.remd.remd_annonces.service.impl.CommentairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("annonces/")
public class CommentairesController {
    @Autowired
    private CommentairesService commentairesService;
    @Autowired
    private UserProxy userProxy;

    @PostMapping("commentaire/create")
    public Commentaires create (@RequestBody Commentaires commentaires){
        Commentaires _commentaires = commentairesService.create(commentaires);
        return _commentaires;
    }

    @GetMapping("commentaires/{idAnnonce}")
    public ResponseEntity<?> getByUser(@PathVariable("idAnnonce") Long idAnnonces){
        List<Commentaires> commentairesList = commentairesService.findByIdAnnonces(idAnnonces);
        for (Commentaires comment : commentairesList){
            Users users = userProxy.getById(comment.getIdUsers());
            comment.setUsers(users);
        }
        return new ResponseEntity<>(commentairesList, HttpStatus.OK);
    }
}