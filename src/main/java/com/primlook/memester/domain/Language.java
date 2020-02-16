package com.primlook.memester.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Bernardo on 1/26/2020
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Language extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "languages")
    private Set<Profile> profile;
}
