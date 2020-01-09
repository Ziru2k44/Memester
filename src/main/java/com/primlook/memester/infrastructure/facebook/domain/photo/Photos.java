package com.primlook.memester.infrastructure.facebook.domain.photo;

import com.primlook.memester.infrastructure.facebook.domain.common.Paging;
import lombok.Data;

import java.util.List;

/**
 * Created by Bernardo on 10/6/2019
 */
@Data
public class Photos {

    private List<Photo> data;

    private Paging paging;

}
