package com.remd.remd_annonces.models;

import com.remd.remd_annonces.Beans.Users;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;


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
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate = new Date();
    private Long idUsers;
    @Transient
    private Users users;

}
