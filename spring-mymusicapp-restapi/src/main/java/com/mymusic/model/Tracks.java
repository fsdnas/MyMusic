package com.mymusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Tracks {
    @Id
    @GeneratedValue(generator = "tracks_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "tracks_seq", sequenceName = "tracks_sequence", initialValue = 1000000, allocationSize = 1)
    private Long trackId;
    private String trackName;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonIgnore
    private Album album;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tracks_artist", joinColumns = @JoinColumn(name = "track_id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
    @ToString.Exclude

    private Set<Artist> artists;

    private double rating;
    private LocalDate releaseDate;
    private String composer;

    public Tracks(String trackName, Set<Artist> artists, double rating, LocalDate releaseDate, String composer) {
        this.trackName = trackName;
        this.artists = artists;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.composer = composer;
    }

    @Override
    public String toString() {
        return "Tracks{" +
                "trackName='" + trackName + '\'' +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate +
                ", composer='" + composer + '\'' +
                '}';
    }
}




