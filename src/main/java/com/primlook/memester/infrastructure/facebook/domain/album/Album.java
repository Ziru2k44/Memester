package com.primlook.memester.infrastructure.facebook.domain.album;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Bernardo on 10/6/2019
 */
@Data
public class Album {

    private String name;

    private Integer count;

    @JsonProperty("cover_photo")
    private CoverPhoto coverPhoto;

    private String id;
}
