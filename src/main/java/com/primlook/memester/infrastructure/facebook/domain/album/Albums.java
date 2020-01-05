package com.primlook.memester.infrastructure.facebook.domain.album;

import lombok.Data;

import java.util.List;

/**
 * Created by Bernardo on 10/6/2019
 */
@Data
public class Albums {

    private List<Album> data;

    private Paging paging;

}
