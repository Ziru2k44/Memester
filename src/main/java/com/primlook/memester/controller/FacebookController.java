package com.primlook.memester.controller;

import com.primlook.memester.infrastructure.facebook.domain.album.AlbumResponse;
import com.primlook.memester.infrastructure.facebook.domain.album.Albums;
import com.primlook.memester.infrastructure.facebook.domain.photo.Photos;
import com.primlook.memester.service.FacebookService;
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

    private final FacebookService facebookService;

    @GetMapping("/albums")
    @PreAuthorize("hasRole('USER')")
    public AlbumResponse getAlbums() {
        return facebookService.getAlbums();
    }

    @GetMapping("/albums/{id}")
    @PreAuthorize("hasRole('USER')")
    public Albums getAlbums(@PathVariable("id") String albumId,
                            @RequestParam(name = "after", required = false) String after,
                            @RequestParam(name = "before", required = false) String before) {
        return facebookService.getPagingAlbums(albumId, after, before);
    }

    @GetMapping("/album/{id}/photos")
    @PreAuthorize("hasRole('USER')")
    public Photos getPhotos(@PathVariable("id") String albumId,
                            @RequestParam(name = "after", required = false) String after,
                            @RequestParam(name = "before", required = false) String before) {
        return facebookService.getPhotos(albumId, after, before);
    }


}
