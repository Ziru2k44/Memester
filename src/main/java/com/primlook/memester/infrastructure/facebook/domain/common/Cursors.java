package com.primlook.memester.infrastructure.facebook.domain.common;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Bernardo on 10/13/2019
 */
@Data
@Builder
public class Cursors {

    private String before;

    private String after;
}
