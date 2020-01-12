package com.primlook.memester.infrastructure.facebook.domain.common;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Bernardo on 10/13/2019
 */
@Data
@Builder
public class Paging {

    private Cursors cursors;

    private String next;

    private String previous;

}
