package com.remd.remd_annonces.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Data
@DynamicUpdate
public class Commentaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    private Annonces annonces;
    // id de celui qui fait le commentaire
    private Long idUsers;

}
