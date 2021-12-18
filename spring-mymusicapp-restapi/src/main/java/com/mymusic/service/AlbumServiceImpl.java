package com.mymusic.service;

import com.mymusic.exceptions.AlbumNotFoundException;
import com.mymusic.model.Album;
import com.mymusic.model.Label;
import com.mymusic.model.Language;
import com.mymusic.repository.IAlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {

    private final IAlbumRepository albumRepository;

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
    public List<Album> getByAlbumName(String albumName) throws AlbumNotFoundException {
        return albumRepository.findByAlbumName(albumName);
    }

    @Override
    public List<Album> getByLanguage(String language) throws AlbumNotFoundException {
        return albumRepository.findByLanguage(Language.valueOf(language));
    }

    @Override
    public List<Album> getByLabel(String label) throws AlbumNotFoundException {
        return albumRepository.findByLabel(Label.valueOf(label));
    }

    @Override
    public List<Album> getByGenre(String genre) throws AlbumNotFoundException {
        return albumRepository.findByGenre(genre);
    }

    @Override
    public List<Album> getByAlbumAndArtist(String albumName, String artistName) throws AlbumNotFoundException {
        return albumRepository.findByAlbumAndArtist(albumName, artistName);
    }

    @Override
    public List<Album> getByAlbumNameContaining(String albumName) throws AlbumNotFoundException {
        return albumRepository.findByAlbumNameContaining(albumName);
    }
}
