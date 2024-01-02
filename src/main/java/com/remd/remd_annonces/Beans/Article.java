package com.remd.remd_annonces.Beans;

import lombok.Data;

@Data
public class Article {
    private Long id;
    private String nom;
    private String photo;
    private String description;
    private ArticleState state;
}
