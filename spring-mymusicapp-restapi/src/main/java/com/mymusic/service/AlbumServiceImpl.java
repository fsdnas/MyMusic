package com.mymusic.service;

import com.mymusic.controllers.AlbumController;
import com.mymusic.exceptions.AlbumNotFoundException;
import com.mymusic.model.Album;
import com.mymusic.model.Label;
import com.mymusic.model.Language;
import com.mymusic.repository.IAlbumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {

    private final IAlbumRepository albumRepository;
    private final Logger logger = LoggerFactory.getLogger(AlbumController.class);

    public AlbumServiceImpl(IAlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album addAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void updateAlbum(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(int albumId) {
        albumRepository.deleteById(albumId);
    }

    @Override
    public Album getByAlbumId(int albumId) throws AlbumNotFoundException {
        return albumRepository.findById(albumId).orElseThrow(() -> new AlbumNotFoundException("Album not found"));
    }

    @Override
    public List<Album> getAll() {
        return albumRepository.findAll();
    }


    @Override
    public List<Album> getByLanguage(String language) throws AlbumNotFoundException {
        List<Album> album = albumRepository.findByLanguage(Language.valueOf(language));
        if (album.isEmpty()) {
            logger.warn("throws AlbumNotFoundException");
            logger.error("Album not found");
            throw new AlbumNotFoundException("Invalid Data");
        }
        return album;
    }

    @Override
    public List<Album> getByLabel(String label) throws AlbumNotFoundException {
        List<Album> album = albumRepository.findByLabel(Label.valueOf(label));
        if (album.isEmpty()) {
            logger.warn("throws AlbumNotFoundException");
            logger.error("Album not found");
            throw new AlbumNotFoundException("Invalid Data");
        }
        return album;
    }

    @Override
    public List<Album> getByGenre(String genre) throws AlbumNotFoundException {
        List<Album> album = albumRepository.findByGenre(genre);
        if (album.isEmpty()) {
            logger.warn("throws AlbumNotFoundException");
            logger.error("Album not found");
            throw new AlbumNotFoundException("Invalid Data");
        }
        return album;
    }

    @Override
    public List<Album> getByAlbumAndArtist(String albumName, String artistName) throws AlbumNotFoundException {
        List<Album> album = albumRepository.findByAlbumAndArtist(albumName, artistName);
        if (album.isEmpty()) {
            logger.warn("throws AlbumNotFoundException");
            logger.error("Album not found");
            throw new AlbumNotFoundException("Invalid Data");
        }
        return album;
    }

    @Override
    public List<Album> getByAlbumNameContaining(String albumName) throws AlbumNotFoundException {
        List<Album> album = albumRepository.findByAlbumNameContaining(albumName);
        if (album.isEmpty()) {
            logger.warn("throws AlbumNotFoundException");
            logger.error("Album not found");
            throw new AlbumNotFoundException("Invalid Data");
        }
        return album;
    }
}
