package com.primlook.memester.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Bernardo on 3/1/2020
 */
@AllArgsConstructor
@Data
public class ListResource<T> implements Serializable {

    private static final long serialVersionUID = -6971839320086716576L;

    private T content;

    private PageInfo pageInfo;
}
