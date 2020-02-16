package com.primlook.memester.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Bernardo on 1/26/2020
 */
@Getter
@Setter
@Entity
public class Category extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Meme> memes;

    @ManyToMany(mappedBy = "categories")
    private Set<Profile> profile;
}
