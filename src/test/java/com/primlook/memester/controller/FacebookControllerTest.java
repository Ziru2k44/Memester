package com.primlook.memester.controller;

import com.primlook.memester.infrastructure.facebook.domain.album.Album;
import com.primlook.memester.infrastructure.facebook.domain.album.AlbumResponse;
import com.primlook.memester.infrastructure.facebook.domain.album.Albums;
import com.primlook.memester.infrastructure.facebook.domain.album.CoverPhoto;
import com.primlook.memester.infrastructure.facebook.domain.common.Cursors;
import com.primlook.memester.infrastructure.facebook.domain.common.Paging;
import com.primlook.memester.infrastructure.facebook.service.UploadService;
import com.primlook.memester.security.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Bernardo on 1/12/2020
 */
@WebMvcTest(FacebookController.class)
class FacebookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UploadService uploadService;

    @MockBean
    CustomUserDetailsService customUserDetailsService;

    @MockBean
    CustomOAuth2UserService customOAuth2UserService;

    @MockBean
    OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @MockBean
    OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    @MockBean
    TokenProvider tokenProvider;

    @MockBean
    ClientRegistrationRepository clientRegistrationRepository;


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
        given(uploadService.getAlbums()).willReturn(albumResponse);
        //given(tokenProvider.validateToken(any())).willReturn(true);

        long EXPIRATIONTIME = 864000000; // 10 days
        String SECRET = "926D96C90030DD58429D2751AC1BDBBC";

        String jwt = Jwts.builder()
                .setSubject("Nuno")
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();


        // Then
        mockMvc.perform(get("/facebook/albums").header("Authorization", jwt).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAlbums() {
    }

    @Test
    void getPhotos() {
    }
}