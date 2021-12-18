package com.mymusic.service;

import com.mymusic.exceptions.TrackNotFoundException;
import com.mymusic.model.Tracks;

import java.util.List;

public interface ITracksService {

    Tracks addTrack(Tracks track);

    void updateTrack(Tracks track);

    void deleteTrack(long trackId);

    Tracks getByTrackId(Long trackId) throws TrackNotFoundException;

    List<Tracks> getAllTracks();

    Tracks getByTrackName(String trackName) throws TrackNotFoundException;

    List<Tracks> getByArtistName(String artistName) throws TrackNotFoundException;

    List<Tracks> getByComposer(String composer) throws TrackNotFoundException;

    List<Tracks> getByReleaseDate(String releaseDate) throws TrackNotFoundException;

    List<Tracks> getByReleasedAtBetween(String startDate, String endDate) throws TrackNotFoundException;

    List<Tracks> getByComposerAndArtist(String composer, String artist) throws TrackNotFoundException;




}
