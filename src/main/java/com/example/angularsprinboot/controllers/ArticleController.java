package com.example.angularsprinboot.controllers;

import com.example.angularsprinboot.models.Article;
import com.example.angularsprinboot.models.ArticleRequest;
import com.example.angularsprinboot.services.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/addArticle")
    public ResponseEntity<Article> addArticle(
            @RequestParam("article") String articleRequestJson,
            @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        // Convert the JSON string to ArticleRequest object
        ObjectMapper objectMapper = new ObjectMapper();
        ArticleRequest articleRequest = objectMapper.readValue(articleRequestJson, ArticleRequest.class);

        // Call the service method to handle the business logic
        Article article = articleService.addArticle(articleRequest, imageFile);

        return ResponseEntity.ok(article);
    }
    @GetMapping("/getAllArticles")
    public List<Article> getArticles(){
        return articleService.getAllArticle();
    }

    @GetMapping("/getArticleById/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable ("id") Long id){
        System.out.println("Fetching article with ID: " + id);
        Optional<Article> article = articleService.getByIdArticle(id);

        System.out.println("Fetching article : " + article);

        if (article.isPresent()) {
            return ResponseEntity.ok(article.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/deleteArticle/{id}")
    public void deleteByIdArticle(@PathVariable ("id") Long id) {

                articleService.DeleteByIdArticle(id);
    }
    @PutMapping("/updateArticle/{id}")
    public Article updateByIdArticle(@PathVariable ("id") Long id , @RequestBody Article article){
      return
               articleService.updateArticle(id,article);

    }




}
