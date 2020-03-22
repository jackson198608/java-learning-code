package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MangaResponse {
    private String request_hash;
    private Boolean request_cached;
    private Integer request_cache_expiry;
    private Manga[] results;

}
