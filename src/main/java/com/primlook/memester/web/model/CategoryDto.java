package com.primlook.memester.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Created by Bernardo on 1/19/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    @Null( message = "${validatedValue} must be null")
    private Long id;

    @NotNull
    private String description;
}
