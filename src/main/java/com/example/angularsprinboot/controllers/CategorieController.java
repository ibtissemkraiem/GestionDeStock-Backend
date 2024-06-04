package com.example.angularsprinboot.controllers;

import com.example.angularsprinboot.models.Categorie;
import com.example.angularsprinboot.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController


@RequestMapping("/api/categorie")
public class CategorieController {

    @Autowired
    CategorieService categorieService;


    @PostMapping("/addCategorie")
    public Categorie addCategory(@RequestBody Categorie categorie){
        return categorieService.addCategory(categorie);
    }


    @GetMapping("/getAllCategorie")

    public List<Categorie> getAllCategories(){
        return categorieService.getAllCategorie();
    }
}
