package com.example.demo.models;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//generate from IDE
class MangaTest {
    private final Manga manga = new Manga();
    @Test
    @Order(1)
    void setMal_id(){
       manga.setMal_id(10);
    }

    @Test
    @Order(2)
    void getMal_id() {
        manga.setMal_id(10);
        assertEquals(manga.getMal_id(),10);
    }

    @Test
    void getUrl() {
    }

    @Test
    void getImage_url() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void getPublishing() {
    }

    @Test
    void getSynopsis() {
    }

    @Test
    void getType() {
    }

    @Test
    void getChapters() {
    }
}