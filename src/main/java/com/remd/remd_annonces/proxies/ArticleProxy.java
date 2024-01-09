package com.remd.remd_annonces.proxies;


import com.remd.remd_annonces.Beans.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "remd-articles", url = "localhost:9001")
public interface ArticleProxy {
    @GetMapping("articles/{id}")
    ResponseEntity<?> getById(@PathVariable("id")Long id);
    @PutMapping("articles/perdu/{id}")
    void marquerPerdu(@PathVariable Long id);
    @GetMapping("articles/{id}")
    Article findById(@PathVariable("id") Long id);

    @PostMapping(value = "articles/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> create (@RequestPart("nom") String nom,
                                     @RequestPart("photo") MultipartFile photo,
                                     @RequestPart("description") String description,
                                     @RequestPart("idUser")Long idUser);
}
