package com.example.angularsprinboot.models;

import lombok.Data;

@Data


public class ArticleRequest {
    private String designation;
    private String codeArticle;
    private float prixHT;

    private float prixTTC;

    private int tauxTVA;
    private Long idCategorie;
}
