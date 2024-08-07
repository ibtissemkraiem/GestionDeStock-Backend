package com.example.angularsprinboot.services;

import com.example.angularsprinboot.Repositories.ArticleRepository;
import com.example.angularsprinboot.Repositories.CategoryRepository;
import com.example.angularsprinboot.models.Article;
import com.example.angularsprinboot.models.ArticleRequest;

import com.example.angularsprinboot.models.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;


@Service
public class ArticleServiceImpl implements ArticleService {



    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CategoryRepository categoryRepository;


    private static final String UPLOAD_DIR = "src/uploads/";



    @Override
    public Article addArticle(ArticleRequest articleRequest, MultipartFile imageFile) throws IOException {
        // Validate category
        Categorie category = categoryRepository.findById(articleRequest.getIdCategorie())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Create new Article
        Article article = new Article();
        article.setDesignation(articleRequest.getDesignation());
        article.setCodeArticle(articleRequest.getCodeArticle());
        article.setPrixHT(articleRequest.getPrixHT());
        article.setTauxTVA(articleRequest.getTauxTVA());
        article.setCategorie(category);

        // Calculate prixTTC if it's not provided
        if (articleRequest.getPrixTTC() == 0.0) {
            article.setPrixTTC(articleRequest.getPrixHT() * articleRequest.getTauxTVA() / 100);
        } else {
            article.setPrixTTC(articleRequest.getPrixTTC());
        }

        // Handle image file
        if (imageFile != null && !imageFile.isEmpty()) {
            String imagePath = saveImage(imageFile);
            article.setImagePath(imagePath);
        }

        // Save article
        return articleRepository.save(article);
    }
    private String saveImage(MultipartFile imageFile) throws IOException {
        // Ensure the upload directory exists
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Get the original filename and build the path
        String originalFilename = imageFile.getOriginalFilename();
        Path filePath = uploadPath.resolve(originalFilename);

        // Save the file
        try (InputStream inputStream = imageFile.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        // Return the relative path to the application root
        return filePath.toString();
    }



    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> getByIdArticle(Long id) {

        return articleRepository.findById(id);
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
