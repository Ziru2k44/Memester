package com.primlook.memester.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Set;

/**
 * Created by Bernardo on 1/19/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemeDto implements Serializable {

    private static final long serialVersionUID = 7800729392868951865L;

    @Null
    private String id;
    
    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @NotBlank
    private String imageUrl;

    @NotNull
    private String description;

    @NotNull
    private LanguageDto language;

    @Null
    private Long author;

    @Null
    private Integer score;

    @Null
    private Integer likes;

    @Null
    private Integer dislikes;

    @Null
    private Integer totalVotes;

    @Valid
    private Set<CategoryDto> categories;
}
