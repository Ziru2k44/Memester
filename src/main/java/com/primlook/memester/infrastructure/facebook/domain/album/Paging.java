package com.primlook.memester.infrastructure.facebook.domain.album;

import lombok.Data;

/**
 * Created by Bernardo on 10/13/2019
 */
@Data
public class Paging {

    private Cursors cursors;

    private String next;

    private String previous;

}
