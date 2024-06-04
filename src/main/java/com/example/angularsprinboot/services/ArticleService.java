package com.example.angularsprinboot.services;

import com.example.angularsprinboot.models.Article;
import com.example.angularsprinboot.models.ArticleRequest;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    public Article addArticle(ArticleRequest articleRequest);

    public List<Article> getAllArticle();

    public Optional<Article> getByIdArticle(Long id);


}
