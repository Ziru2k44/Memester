package com.primlook.memester.controller;

import com.primlook.memester.infrastructure.facebook.domain.album.AlbumResponse;
import com.primlook.memester.infrastructure.facebook.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/albums/{id}")
    @PreAuthorize("hasRole('USER')")
    public AlbumResponse getAlbums(@PathVariable("id") String albumId,
                                   @RequestParam(name = "after", required = false) String after,
                                   @RequestParam(name = "before", required = false) String before) {
        return uploadService.getPagingAlbums(albumId, after, before);
    }
}
