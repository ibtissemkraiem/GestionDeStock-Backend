package com.example.angularsprinboot.controllers;

import com.example.angularsprinboot.models.Article;
import com.example.angularsprinboot.models.ArticleRequest;
import com.example.angularsprinboot.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/addArticle")
    public Article addArticle(@RequestBody ArticleRequest articleRequest){
        return articleService.addArticle(articleRequest);

    }
    @GetMapping("/getAllArticles")
    public List<Article> getArticles(){
        return articleService.getAllArticle();
    }



}
