package com.mymusic.service;

import com.mymusic.controllers.TracksResponseController;
import com.mymusic.exceptions.TrackNotFoundException;
import com.mymusic.model.Tracks;
import com.mymusic.repository.ITracksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TracksServiceImpl implements ITracksService {
    private final Logger logger = LoggerFactory.getLogger(TracksResponseController.class);
    private final ITracksRepository tracksRepository;

    public TracksServiceImpl(ITracksRepository tracksRepository) {
        this.tracksRepository = tracksRepository;
    }

    @Override
    public Tracks addTrack(Tracks track) {
        return tracksRepository.save(track);
    }

    @Override
    public void updateTrack(Tracks track) {
        tracksRepository.save(track);
    }

    @Override
    public void deleteTrack(long trackId) {
        tracksRepository.deleteById(trackId);
    }

    @Override
    public Tracks getByTrackId(Long trackId) throws TrackNotFoundException {
        return tracksRepository.findById(trackId).orElseThrow(() -> new TrackNotFoundException("Track not found"));
    }

    @Override
    public List<Tracks> getAllTracks() {
        return tracksRepository.findAll();
    }

    @Override
    public Tracks getByTrackName(String trackName) throws TrackNotFoundException {
        return tracksRepository.findByTrackName(trackName);
    }


    @Override
    public List<Tracks> getByArtistName(String artistName) throws TrackNotFoundException {
        List<Tracks> tracks = tracksRepository.findByArtistName(artistName);
        if (tracks.size() == 0) {
            logger.warn("throws TrackNotFoundException");
            logger.error("Tracks not found");
            throw new TrackNotFoundException("No tracks found");
        }
        return tracks;
    }

    @Override
    public List<Tracks> getByComposer(String composer) throws TrackNotFoundException {
        List<Tracks> tracks = tracksRepository.findByComposer(composer);
        if (tracks.size() == 0) {
            logger.warn("throws TrackNotFoundException");
            logger.error("Tracks not found");
            throw new TrackNotFoundException("No tracks found");
        }
        return tracks;
    }

    @Override
    public List<Tracks> getByReleaseDate(String dateReleased) throws TrackNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate releaseDate = LocalDate.parse(dateReleased, formatter);
        List<Tracks> tracks = tracksRepository.findByReleaseDate(releaseDate);
        if (tracks.size() == 0) {
            logger.warn("throws TrackNotFoundException");
            logger.error("Tracks not found");
            throw new TrackNotFoundException("No tracks found");
        }
        return tracks;
    }

    @Override
    public List<Tracks> getByReleasedAtBetween(String start, String end) throws TrackNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);

        List<Tracks> tracks = tracksRepository.findByreleaseDateBetween(startDate, endDate);
        if (tracks.size() == 0) {
            logger.warn("throws TrackNotFoundException");
            logger.error("Tracks not found");
            throw new TrackNotFoundException("No tracks found");
        }
        return tracks;
    }

    @Override
    public List<Tracks> getByComposerAndArtist(String composer, String artist) throws TrackNotFoundException {
        List<Tracks> tracks = tracksRepository.findByComposerAndArtists(composer, artist);
        if (tracks.size() == 0) {
            logger.warn("throws TrackNotFoundException");
            logger.error("Tracks not found");
            throw new TrackNotFoundException("No tracks found");
        }
        return tracks;
    }
}
