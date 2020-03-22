package com.example.demo.controller;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import com.example.demo.controller.MangaController;
import com.example.demo.models.Manga;
import com.example.demo.service.MangaService;
@SpringBootTest
public class MangaControllerTest {
    MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    MangaController mangaController;
    @MockBean
    MangaService mangaService;
    /**
     * List of samples mangas
     */
    private Manga[] mangas;
    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.mangaController).build();// Standalone context
        // mockMvc = MockMvcBuilders.webAppContextSetup(wac)
        // .build();
        Manga manga1 = Manga.builder()
                .title("Hokuto no ken")
                .build();
        Manga manga2 = Manga.builder()
                .title("Yumekui Kenbun")
                .build();
        mangas=new Manga[2];
        mangas[0]=manga1;
        mangas[1]=manga2;
    }
    @Test
    public void testSearchSync() throws Exception {
        // Mocking service
        System.out.println("mangas:"+mangas.toString());
        when(mangaService.getMangasByTitle(any(String.class))).thenReturn(mangas);
        mockMvc.perform(get("/manga/sync/ken").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Hokuto no ken")))
                .andExpect(jsonPath("$[1].title", is("Yumekui Kenbun")));
    }
    @Test
    public void testSearchASync() throws Exception {
        // Mocking service
        when(mangaService.getMangasByTitle(any(String.class))).thenReturn(mangas);
        MvcResult result = mockMvc.perform(get("/manga/async/ken").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(request().asyncStarted())
                .andDo(print())
                // .andExpect(status().is2xxSuccessful()).andReturn();
                .andReturn();
        // result.getRequest().getAsyncContext().setTimeout(10000);
        mockMvc.perform(asyncDispatch(result))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Hokuto no ken")));
    }
}

