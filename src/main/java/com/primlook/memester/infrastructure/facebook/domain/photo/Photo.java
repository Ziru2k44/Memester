package com.primlook.memester.infrastructure.facebook.domain.photo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by Bernardo on 1/8/2020
 */
@Data
public class Photo {

    @JsonProperty("webp_images")
    private List<Image> webpImages;

    @JsonProperty("created_time")
    private String createTime;

    private String id;
}
