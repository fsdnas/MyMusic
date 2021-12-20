package com.mymusic.controllers;


import com.mymusic.exceptions.TrackNotFoundException;
import com.mymusic.model.Tracks;
import com.mymusic.service.ITracksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tracks-response-api")
public class TracksController {

    private final Logger logger = LoggerFactory.getLogger(TracksController.class);
    private final ITracksService trackService;

    public TracksController(ITracksService trackService) {
        this.trackService = trackService;
    }


    @PostMapping("/track/add")
    ResponseEntity<Tracks> addTrack(@RequestBody Tracks track) {
        HttpHeaders headers = new HttpHeaders();
        Tracks newTrack = trackService.addTrack(track);
        headers.add("desc", "Track added successfully");
        logger.info("Track added successfully" + newTrack);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newTrack);
    }


    @PutMapping("/track/update")
    ResponseEntity<Void> updateTrack(@RequestParam Tracks track) {
        HttpHeaders headers = new HttpHeaders();
        trackService.updateTrack(track);
        headers.add("desc", "Track updated successfully");
        logger.info("Track updated successfully" + track);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }


    @DeleteMapping("/track/delete/id/{trackId}")
    ResponseEntity<Void> deleteTrack(@PathVariable("trackId") long trackId) {
        HttpHeaders headers = new HttpHeaders();
        trackService.deleteTrack(trackId);
        headers.add("desc", "Track deleted successfully");
        logger.info("Track deleted successfully" + trackId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @GetMapping("/track/trackId/{trackId}")
    ResponseEntity<Tracks> getByTrackId(@PathVariable("trackId") long trackId) throws TrackNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        Tracks track = trackService.getByTrackId(trackId);
        headers.add("desc", "Track found successfully");
        logger.info("Track found successfully" + track);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(track);

    }

    @GetMapping("/tracks")
    ResponseEntity<List<Tracks>> getAllTracks() {
        HttpHeaders headers = new HttpHeaders();
        List<Tracks> tracks = trackService.getAllTracks();
        headers.add("desc", "All tracks found successfully");
        logger.info("All tracks found successfully" + tracks);
        return ResponseEntity.ok().headers(headers).body(tracks);
    }

    @GetMapping("/track/name/{trackName}")
    ResponseEntity<Tracks> getByTrackName(@PathVariable("trackName") String trackName) throws TrackNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        Tracks track = trackService.getByTrackName(trackName);
        headers.add("desc", "Tracks found successfully");
        logger.info("Tracks found successfully" + track);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(track);
    }

    @GetMapping("/tracks/artist/{artistName}")
    ResponseEntity<List<Tracks>> getByArtistName(@PathVariable("artistName") String artistName) throws TrackNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        List<Tracks> tracks = trackService.getByArtistName(artistName);
        headers.add("desc", "Tracks found successfully");
        logger.info("Tracks found successfully" + tracks);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(tracks);
    }

    @GetMapping("/tracks/composer/{composedBy}")
    ResponseEntity<List<Tracks>> getByComposer(@PathVariable("composedBy") String composedBy) throws TrackNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        List<Tracks> tracks = trackService.getByComposer(composedBy);
        headers.add("desc", "Tracks found successfully");
        logger.info("Tracks found successfully" + tracks);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(tracks);
    }

    @GetMapping("/tracks/releaseDate/{releaseDate}")
    ResponseEntity<List<Tracks>> getByReleaseDate(@PathVariable("releaseDate") String releaseDate) throws TrackNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        List<Tracks> tracks = trackService.getByReleaseDate(releaseDate);
        headers.add("desc", "Tracks found successfully");
        logger.info("Tracks found successfully" + tracks);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(tracks);
    }

    @GetMapping("/tracks/releaseDateBetween")
    ResponseEntity<List<Tracks>> getByReleasedAtBetween(@RequestParam("startdate") String startDate, @RequestParam("enddate") String endDate) throws TrackNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        List<Tracks> tracks = trackService.getByReleasedAtBetween(startDate, endDate);
        headers.add("desc", "Tracks found successfully");
        logger.info("Tracks found successfully" + tracks);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(tracks);
    }

    @GetMapping("/tracks/composedBy/{composedBy}/artist/{artistName}")
    ResponseEntity<List<Tracks>> getByComposerAndArtist(@PathVariable("composedBy") String composedBy, @PathVariable("artistName") String artistName) throws TrackNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        List<Tracks> tracks = trackService.getByComposerAndArtist(composedBy, artistName);
        headers.add("desc", "Tracks found successfully");
        logger.info("Tracks found successfully" + tracks);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(tracks);
    }

}
