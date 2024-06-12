package com.example.angularsprinboot.services;

import com.example.angularsprinboot.Repositories.ArticleRepository;
import com.example.angularsprinboot.Repositories.CategoryRepository;
import com.example.angularsprinboot.models.Article;
import com.example.angularsprinboot.models.ArticleRequest;

import com.example.angularsprinboot.models.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ArticleServiceImpl implements ArticleService {



    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CategoryRepository categoryRepository;



    @Override
    public Article addArticle(ArticleRequest articleRequest) {
        System.out.println(articleRequest.getIdCategorie());

        Categorie category = categoryRepository.findById(articleRequest.getIdCategorie())
                .orElseThrow(() -> new RuntimeException("Category not found"));


        //yelzemni instance bsh nsseti les donnees e jdod
        Article article = new Article();
     article.setDesignation(articleRequest.getDesignation());
        article.setPrixHT(articleRequest.getPrixHT());
        article.setTauxTVA(articleRequest.getTauxTVA());
        article.setCategorie(category); // Calculate prixTTC if it's not provided
    if (articleRequest.getPrixTTC() == 0.0)
       { article.setPrixTTC(articleRequest.getPrixHT() * articleRequest.getTauxTVA() / 100); }
    else { article.setPrixTTC(articleRequest.getPrixTTC()); }
        return articleRepository.save(article);
    }



    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> getByIdArticle(Long id) {
        return Optional.empty();
    }


    @Override

    public void DeleteByIdArticle(Long id){
      articleRepository.deleteById(id) ;


    }

    public Article updateArticle(Long id , Article newArticle){
        return
                articleRepository.findById(id).map(
                        article -> {
                            article.setDesignation(newArticle.getDesignation());
                            article.setCodeArticle(newArticle.getCodeArticle());
                            article.setPrixHT(newArticle.getPrixHT());


                            article.setPrixTTC(newArticle.getPrixHT() * article.getTauxTVA() / 100);



                            return
                                    articleRepository.save(article);

                        } )




                        .orElseThrow(()->new RuntimeException("Article Not found with id" + id )

                        );
    }
}
