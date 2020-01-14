package com.primlook.memester.service;

import com.primlook.memester.infrastructure.facebook.domain.album.AlbumResponse;
import com.primlook.memester.infrastructure.facebook.domain.album.Albums;
import com.primlook.memester.infrastructure.facebook.domain.photo.Photos;
import com.primlook.memester.infrastructure.facebook.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Bernardo on 1/12/2020
 */
@Service
@RequiredArgsConstructor
public class FacebookServiceImpl implements FacebookService {

    private final UploadService uploadService;

    @Override
    public AlbumResponse getAlbums() {
        return uploadService.getAlbums();
    }

    @Override
    public Albums getPagingAlbums(String albumId, String after, String before) {
        return uploadService.getPagingAlbums(albumId, after, before);
    }

    @Override
    public Photos getPhotos(String albumId, String after, String before) {
        Photos photos = uploadService.getPhotos(albumId, after, before);

        //photos.getData().parallelStream().forEach(photo -> photo.setWebpImages(photo.getWebpImages().subList(photo.getWebpImages().size() - 1, photo.getWebpImages().size())));

        return photos;
    }
}
