package com.example.demo.service;

import java.util.List;

import com.example.demo.models.MangaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.models.Manga;
import com.example.demo.models.MangaResult;

@Service
public class MangaService {
    Logger logger = LoggerFactory.getLogger(MangaService.class);
    private static final String MANGA_SEARCH_URL = "https://api.jikan.moe/v3/search/manga?q=";
    @Autowired
    RestTemplate restTemplate;

    public Manga[] getMangasByTitle(String title) {
        return restTemplate.getForEntity(MANGA_SEARCH_URL + title, MangaResponse.class).getBody().getResults();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

