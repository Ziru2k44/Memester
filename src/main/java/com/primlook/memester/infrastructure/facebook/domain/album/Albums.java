package com.primlook.memester.infrastructure.facebook.domain.album;

import com.primlook.memester.infrastructure.facebook.domain.common.Paging;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by Bernardo on 10/6/2019
 */
@Data
@Builder
public class Albums {

    private List<Album> data;

    private Paging paging;

}
