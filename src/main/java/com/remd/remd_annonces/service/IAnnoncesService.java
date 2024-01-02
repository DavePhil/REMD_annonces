package com.remd.remd_annonces.service;

import com.remd.remd_annonces.models.Annonces;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAnnoncesService {
    Annonces create(Annonces annonces);
    Annonces update(Annonces annonces);
    List<Annonces> getAll();
    ResponseEntity<?> delete(Long id);
}
