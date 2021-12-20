package com.mymusic.repository;

import com.mymusic.exceptions.AlbumNotFoundException;
import com.mymusic.model.Album;
import com.mymusic.model.Label;
import com.mymusic.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IAlbumRepository extends JpaRepository<Album, Integer> {


    List<Album> findByLanguage(Language language) throws AlbumNotFoundException;

    List<Album> findByLabel(Label label) throws AlbumNotFoundException;

    @Query("from Album a inner join a.genre g where g.genreName LIKE %?1%")
    List<Album> findByGenre(String genre) throws AlbumNotFoundException;

    @Query("from Album a inner join a.tracks t inner join t.artists ar where ar.artistName LIKE %?1% and a.albumName LIKE %?2%")
    List<Album> findByAlbumAndArtist(String albumName, String artistName) throws AlbumNotFoundException;

    @Query("from Album a where a.albumName LIKE %?1%")
    List<Album> findByAlbumNameContaining(String albumName) throws AlbumNotFoundException;

}
