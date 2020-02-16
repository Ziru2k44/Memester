package com.primlook.memester.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Bernardo on 1/26/2020
 */
@Getter
@Setter
@Entity
public class ProfileView extends AbstractEntity{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "profile_fk", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "meme_fk", nullable = false)
    private Meme meme;

    private boolean like;
}
