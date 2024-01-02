package com.remd.remd_annonces.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "remd-articles", url = "localhost:9001")
public interface ArticleProxy {
    @GetMapping("articles/{id}")
    ResponseEntity<?> getById(@PathVariable("id")Long id);
    @PutMapping("articles/perdu/{id}")
    void marquerPerdu(@PathVariable Long id);
}
