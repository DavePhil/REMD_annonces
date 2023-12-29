package com.remd.remd_annonces.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Data
public class Annonces {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

}
