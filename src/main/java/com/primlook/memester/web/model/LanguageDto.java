package com.primlook.memester.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * Created by Bernardo on 1/19/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageDto implements Serializable {

    private static final long serialVersionUID = 6679430269720316063L;

    @Null
    private Long id;

    @NotNull
    private String description;
}
