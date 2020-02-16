package com.primlook.memester.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "meme")
public class Meme extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    private String description;

    @Column(nullable = false)
    @Lob
    private String imageUrl;

    @ManyToOne(optional = false)
    private Profile profile;

    private Integer score;

    private Integer likes;

    private Integer dislikes;

    private Integer totalVotes;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    private Language language;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "meme_category",
            joinColumns = @JoinColumn(name = "meme_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories;

    @OneToMany(mappedBy = "meme")
    private Set<ProfileView> profileViews;
}
