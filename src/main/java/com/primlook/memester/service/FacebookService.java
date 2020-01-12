package com.primlook.memester.service;

import com.primlook.memester.infrastructure.facebook.domain.album.AlbumResponse;
import com.primlook.memester.infrastructure.facebook.domain.album.Albums;
import com.primlook.memester.infrastructure.facebook.domain.photo.Photos;

/**
 * Created by Bernardo on 1/12/2020
 */
public interface FacebookService {

    AlbumResponse getAlbums();

    Albums getPagingAlbums(String albumId, String after, String before);

    Photos getPhotos(String albumId, String after, String before);

}
