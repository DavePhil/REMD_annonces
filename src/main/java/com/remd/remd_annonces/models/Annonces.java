package com.remd.remd_annonces.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class Annonces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String localisation;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate = new Date();
    private String date;
//    private String heure;
    private Long idArticle;
    private Long idUsers;

}
