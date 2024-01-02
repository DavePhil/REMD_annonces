package com.remd.remd_annonces.repository;

import com.remd.remd_annonces.models.Annonces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnoncesRepository extends JpaRepository<Annonces, Long> {

    List<Annonces> findByIdUsers(Long idUsers);

    @Query("select annonces from Annonces annonces where annonces.idUsers !=: idUsers")
    List<Annonces> findByNotIdUsers(@Param("idUsers") Long idUsers);
}
