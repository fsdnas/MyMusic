package com.mymusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Artist {
    @Id
    @GeneratedValue(generator = "artist_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "artist_seq", sequenceName = "artist_sequence", initialValue = 50, allocationSize = 1)
    private Integer artistId;
    private String artistName;
    private String artistDescription;
    private String artistImage;
    private int artistRank;
    @ManyToMany(mappedBy = "artists")
    @JsonIgnore
    private Set<Tracks> tracks;

    public Artist(String artistName, String artistDescription, String artistImage, int artistRank) {
        this.artistName = artistName;
        this.artistDescription = artistDescription;
        this.artistImage = artistImage;
        this.artistRank = artistRank;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistName='" + artistName + '\'' +
                ", artistDescription='" + artistDescription + '\'' +
                ", artistImage='" + artistImage + '\'' +
                ", artistRank=" + artistRank +
                '}';
    }
}
