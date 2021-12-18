package com.mymusic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Album {

    @Id
    @GeneratedValue(generator = "album_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "album_seq", sequenceName = "album_sequence", initialValue = 100, allocationSize = 1)
    private Integer albumId;
    private String albumName;
    private int numberOfTracks;

    @Enumerated(EnumType.STRING)
    private Language language;
    private String albumImage;
    private String albumDescription;

    //album joins genre table
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    //this is an enum
    @Enumerated(EnumType.STRING)
    private Label label;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    @ToString.Exclude
    private Set<Tracks> tracks;

    public Album(String albumName, int numberOfTracks, Language language, String albumImage, String albumDescription, Genre genre, Label label, Set<Tracks> tracks) {
        this.albumName = albumName;
        this.numberOfTracks = numberOfTracks;
        this.language = language;
        this.albumImage = albumImage;
        this.albumDescription = albumDescription;
        this.genre = genre;
        this.label = label;
        this.tracks = tracks;
    }
}
