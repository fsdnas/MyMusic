package com.mymusic.service;

import com.mymusic.exceptions.ArtistNotFoundException;
import com.mymusic.model.Artist;

import java.util.List;

public interface IArtistService {
    Artist addArtist(Artist artist);

    void updateArtist(Artist artist);

    void deleteArtist(int artistId);

    Artist getByArtistId(int artistId) throws ArtistNotFoundException;

    List<Artist> getAllArtists();

    List<Artist> getByArtistRank(int rank) throws ArtistNotFoundException;


}
