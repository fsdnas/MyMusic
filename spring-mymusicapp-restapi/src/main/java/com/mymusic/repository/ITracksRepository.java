package com.mymusic.repository;

import com.mymusic.exceptions.TrackNotFoundException;
import com.mymusic.model.Tracks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITracksRepository extends JpaRepository<Tracks, Long> {
    @Query("from Tracks t where t.trackName LIKE %?1%")
    Tracks findByTrackName(String trackName) throws TrackNotFoundException;

    @Query("from Tracks t inner join t.artists where artistName LIKE %?1%")
    List<Tracks> findByArtistName(String artistName) throws TrackNotFoundException;

    List<Tracks> findByComposer(String composer) throws TrackNotFoundException;

    @Query("from Tracks t where t.releaseDate = ?1")
    List<Tracks> findByReleaseDate(LocalDate releaseDate) throws TrackNotFoundException;

    //    @Query(value = "select * from Tracks t where t.release_date >= :startdate and t.release_date <= :enddate", nativeQuery = true)
    @Query("from Tracks t where t.releaseDate >= ?1 and t.releaseDate <= ?2")
    List<Tracks> findByreleaseDateBetween(LocalDate startDate, LocalDate endDate) throws TrackNotFoundException;


    @Query("from Tracks t inner join t.artists a where t.composer LIKE %?1% and a.artistName LIKE %?2%")
    List<Tracks> findByComposerAndArtists(String composer, String artist) throws TrackNotFoundException;
}
