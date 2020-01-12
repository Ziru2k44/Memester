package com.primlook.memester.infrastructure.facebook.domain.album;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Bernardo on 10/6/2019
 */
@Data
@Builder
public class CoverPhoto {

    private String picture;

    private String id;
}
