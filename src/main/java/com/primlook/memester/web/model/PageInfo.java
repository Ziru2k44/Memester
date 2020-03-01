package com.primlook.memester.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageImpl;

import java.io.Serializable;

/**
 * Created by Bernardo on 3/1/2020
 */
@AllArgsConstructor
@Data
@Builder
public class PageInfo implements Serializable {

    private static final long serialVersionUID = -4475858151099449174L;

    private Integer number;

    private Integer size;

    private long totalElements;

    private Boolean first;

    private Boolean last;

    public PageInfo(PageImpl pageImpl) {
        this.first = pageImpl.isFirst();
        this.last = pageImpl.isLast();
        this.number = pageImpl.getNumber();
        this.size = pageImpl.getSize();
        this.totalElements = pageImpl.getTotalElements();
    }
}
