package com.mymusic.service;

import com.mymusic.exceptions.AlbumNotFoundException;
import com.mymusic.model.Album;

import java.util.List;

public interface IAlbumService {
    Album addAlbum(Album album);

    void updateAlbum(Album album);

    void deleteAlbum(int albumId);

    Album getByAlbumId(int albumId) throws AlbumNotFoundException;

    List<Album> getAll();

    List<Album> getByAlbumName(String albumName) throws AlbumNotFoundException;

    List<Album> getByLanguage(String language) throws AlbumNotFoundException;

    List<Album> getByLabel(String label) throws AlbumNotFoundException;

    List<Album> getByGenre(String genre) throws AlbumNotFoundException;

    List<Album> getByAlbumAndArtist(String albumName, String artistName) throws AlbumNotFoundException;

    List<Album> getByAlbumNameContaining(String albumName) throws AlbumNotFoundException;

}
