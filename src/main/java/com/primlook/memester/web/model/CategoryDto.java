package com.primlook.memester.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Bernardo on 1/19/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto implements Serializable {

    private static final long serialVersionUID = -6508973628756110433L;

    @NotNull
    private Long id;

    private String description;
}
