package com.mymusic.service;

import com.mymusic.exceptions.AlbumNotFoundException;
import com.mymusic.exceptions.ArtistNotFoundException;
import com.mymusic.model.Artist;
import com.mymusic.repository.IArtistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements IArtistService {
    private final IArtistRepository artistRepository;
    private final Logger logger = LoggerFactory.getLogger(ArtistNotFoundException.class);

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
        return artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException("Artist not found"));
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();

    }



    @Override
    public List<Artist> getByArtistRank(int rank) throws ArtistNotFoundException {
        List<Artist> artist = artistRepository.findByArtistRank(rank);
        if (artist.isEmpty()) {
            logger.warn("throws AlbumNotFoundException");
            logger.error("Album not found");
            throw new AlbumNotFoundException("Invalid Data");
        }
        return artist;
    }
}
