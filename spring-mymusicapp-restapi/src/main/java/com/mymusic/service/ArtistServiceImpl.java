package com.mymusic.service;

import com.mymusic.exceptions.ArtistNotFoundException;
import com.mymusic.model.Artist;
import com.mymusic.repository.IArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements IArtistService {
    private final IArtistRepository artistRepository;

    public ArtistServiceImpl(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void updateArtist(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(int artistId) {
        artistRepository.deleteById(artistId);
    }

    @Override
    public Artist getByArtistId(int artistId) throws ArtistNotFoundException {
        return null;
    }

    @Override
    public List<Artist> getAllArtists() {
        return null;
    }

    @Override
    public List<Artist> getByArtistName(String name) throws ArtistNotFoundException {
        return null;
    }

    @Override
    public List<Artist> getByArtistRank(int rank) throws ArtistNotFoundException {
        return null;
    }
}
