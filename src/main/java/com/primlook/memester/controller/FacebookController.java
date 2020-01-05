package com.primlook.memester.controller;

import com.primlook.memester.infrastructure.facebook.domain.album.AlbumResponse;
import com.primlook.memester.infrastructure.facebook.service.UploadService;
import com.primlook.memester.security.CurrentUser;
import com.primlook.memester.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bernardo on 12/30/2019
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/facebook")
public class FacebookController {

    private final UploadService uploadService;

    @GetMapping("/albums")
    @PreAuthorize("hasRole('USER')")
    public AlbumResponse getAlbums() {
        return uploadService.getAlbums();
    }
}
