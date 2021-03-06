package com.example.demo.service;

import com.example.demo.models.Manga;
import com.example.demo.models.MangaResponse;
import com.example.demo.models.MangaResult;
import com.example.demo.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MangaServiceTest {

    @Autowired
    private MangaService mangaService;

    // MockBean is the annotation provided by Spring that wraps mockito one
    // Annotation that can be used to add mocks to a Spring ApplicationContext.
    // If any existing single bean of the same type defined in the context will be replaced by the mock, if no existing bean is defined a new one will be added.
    @MockBean
    private RestTemplate template;

    @Test
    public void testGetMangasByTitle() throws IOException {
        // Parsing mock file
        MangaResponse mRs = JsonUtils.jsonFile2Object("ken.json", MangaResponse.class);
        // Mocking remote service
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity(mRs, HttpStatus.OK));
        // I search for goku but system will use mocked response containing only ken, so I can check that mock is used.
        Manga[] mangasByTitle = mangaService.getMangasByTitle("goku");
        assertThat(mangasByTitle).isNotNull()
                .isNotEmpty()
                .allMatch(p -> p.getTitle()
                        .toLowerCase()
                        .contains("ken"));
    }
}