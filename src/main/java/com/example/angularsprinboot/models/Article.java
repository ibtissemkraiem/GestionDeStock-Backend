package com.example.angularsprinboot.models;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


// taawedh everything
@Data
@Entity
public class Article {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Long idArticle;

    private String designation;
private String codeArticle;
    private float prixHT;

   private float prixTTC;

    private int tauxTVA;

    @ManyToOne
    @JoinColumn(name = "id_category")

    private Categorie categorie;
    // Nom de l'image du produit
   //private String image;

    // Fichier image du produit (transient car non stocké en base de données)
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


}
