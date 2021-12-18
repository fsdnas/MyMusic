package com.mymusic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Genre {
    @Id
    @GeneratedValue(generator = "genre_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "genre_seq", sequenceName = "genre_sequence", initialValue = 30, allocationSize = 1)
    private Integer genreId;
    private String genreName;

    public Genre(String genreName) {
        this.genreName = genreName;
    }
}
