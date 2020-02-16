package com.primlook.memester.web.controller;

import com.primlook.memester.SecurityConfig;
import com.primlook.memester.infrastructure.facebook.domain.album.Album;
import com.primlook.memester.infrastructure.facebook.domain.album.AlbumResponse;
import com.primlook.memester.infrastructure.facebook.domain.album.Albums;
import com.primlook.memester.infrastructure.facebook.domain.album.CoverPhoto;
import com.primlook.memester.infrastructure.facebook.domain.common.Cursors;
import com.primlook.memester.infrastructure.facebook.domain.common.Paging;
import com.primlook.memester.service.FacebookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Bernardo on 1/12/2020
 */
@Import(SecurityConfig.class)
@WebMvcTest(FacebookController.class)
class FacebookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FacebookService facebookService;


    @WithMockUser(value = "spring")
    @Test
    void getAlbums() throws Exception {
        // Given
        AlbumResponse albumResponse = AlbumResponse.builder()
                .albums(Albums.builder()
                        .data(Collections.singletonList(Album.builder()
                                .count(1)
                                .name("name")
                                .coverPhoto(CoverPhoto.builder()
                                        .id("id")
                                        .picture("picture")
                                        .build())
                                .id("id")
                                .build()))
                        .paging(Paging.builder()
                                .cursors(Cursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build())
                                .build())
                        .build())
                .build();

        // When
        given(facebookService.getAlbums()).willReturn(albumResponse);

        // Then
        mockMvc.perform(get("/facebook/albums").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAlbums() {
    }

    @Test
    void getPhotos() {
    }
}