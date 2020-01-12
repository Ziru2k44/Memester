package com.primlook.memester.infrastructure.facebook.service;

import com.primlook.memester.infrastructure.facebook.domain.album.AlbumResponse;
import com.primlook.memester.infrastructure.facebook.domain.album.Albums;
import com.primlook.memester.infrastructure.facebook.domain.photo.Photos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Bernardo on 12/30/2019
 */
@FeignClient(name = "FacebookUploadService", url = "https://graph.facebook.com/v4.0")
public interface UploadService {

    @GetMapping(path = "/me?fields=albums.limit(5){name,count,cover_photo{picture}}", produces = MediaType.APPLICATION_JSON_VALUE)
    AlbumResponse getAlbums();

    @GetMapping(path = "/{id}/albums?fields=name,count,cover_photo%7Bpicture%7D%0A&limit=5", produces = MediaType.APPLICATION_JSON_VALUE)
    Albums getPagingAlbums(@PathVariable("id") String albumId,
                           @RequestParam(name = "after", required = false) String after,
                           @RequestParam(name = "before", required = false) String before);

    @GetMapping(path = "/{id}/photos?fields=name,webp_images,created_time&limit=10", produces = MediaType.APPLICATION_JSON_VALUE)
    Photos getPhotos(@PathVariable("id") String albumId,
                     @RequestParam(name = "after", required = false) String after,
                     @RequestParam(name = "before", required = false) String before);

}
