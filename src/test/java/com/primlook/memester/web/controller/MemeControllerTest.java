package com.primlook.memester.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primlook.memester.SecurityConfig;
import com.primlook.memester.service.MemeService;
import com.primlook.memester.web.model.CategoryDto;
import com.primlook.memester.web.model.LanguageDto;
import com.primlook.memester.web.model.MemeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Bernardo on 1/20/2020
 */
@Import(SecurityConfig.class)
@WebMvcTest(MemeController.class)
class MemeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    MemeService memeService;

    @WithMockUser(value = "spring")
    @Test
    void createMeme() throws Exception {

        // Given
        MemeDto request = MemeDto.builder()
                .description("description")
                .imageUrl("http://wwww")
                .language(LanguageDto.builder()
                        .description("English")
                        .build())
                .categories(Collections.singleton(CategoryDto.builder()
                        .description("SPORTS")
                        .build()))
                .build();

        MemeDto savedDto = MemeDto.builder()
                .author(10L)
                .description("description")
                .imageUrl("http://wwww")
                .language(LanguageDto.builder()
                        .description("English")
                        .build())
                .createdDate(OffsetDateTime.now())
                .likes(0)
                .score(0)
                .totalVotes(0)
                .id(UUID.randomUUID().toString())
                .categories(Collections.singleton(CategoryDto.builder()
                        .description("SPORTS")
                        .build()))
                .build();

        // When
        given(memeService.saveNewMeme(eq(request), anyString())).willReturn(savedDto);

        // Then
        mockMvc.perform(post("/meme")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
                .characterEncoding(StandardCharsets.UTF_8.name()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }
}