package com.mymusic.controllers;

import com.mymusic.exceptions.AlbumNotFoundException;
import com.mymusic.model.Album;
import com.mymusic.service.IAlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album-response-api")
public class AlbumResponseController {

    private final IAlbumService albumService;
    private final Logger logger = LoggerFactory.getLogger(AlbumResponseController.class);

    public AlbumResponseController(IAlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping("/album/add")
    ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        HttpHeaders headers = new HttpHeaders();
        Album newAlbum = albumService.addAlbum(album);
        headers.add("desc", "Album added successfully");
        logger.info("Album added successfully" + newAlbum);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newAlbum);
    }

    @PutMapping("/album/update")
    ResponseEntity<Void> updateAlbum(@RequestParam Album album) {
        HttpHeaders headers = new HttpHeaders();
        albumService.updateAlbum(album);
        headers.add("desc", "Album updated successfully");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @DeleteMapping("/album/delete/{albumId}")
    ResponseEntity<Void> deleteAlbum(@PathVariable("albumId") int albumId) {
        HttpHeaders headers = new HttpHeaders();
        albumService.deleteAlbum(albumId);
        headers.add("desc", "Album deleted successfully");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @GetMapping("/album/id/{albumId}")
    ResponseEntity<Album> getByAlbumId(@PathVariable("albumId") int albumId) throws AlbumNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        Album album = albumService.getByAlbumId(albumId);
        headers.add("desc", "Album found successfully");
        headers.add("info", "Album Details");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(album);
    }

    @GetMapping("/albums")
    ResponseEntity<List<Album>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        List<Album> albumList = albumService.getAll();
        headers.add("desc", "Albums found successfully");
        headers.add("info", "Album Details");
        return ResponseEntity.ok().headers(headers).body(albumList);
    }

    @GetMapping("/album/albumName/{albumName}")
    ResponseEntity<List<Album>> getByAlbumName(@PathVariable("albumName") String albumName) {
        HttpHeaders headers = new HttpHeaders();
        List<Album> albumList = albumService.getByAlbumName(albumName);
        headers.add("desc", "Albums found successfully");
        headers.add("info", "Album Details");
        return ResponseEntity.ok().headers(headers).body(albumList);
    }

    @GetMapping("/album/albumNameLike/{albumNameLike}")
    ResponseEntity<List<Album>> getByAlbumNameContaining(@PathVariable("albumNameLike") String albumNameLike) {
        HttpHeaders headers = new HttpHeaders();
        List<Album> albumList = albumService.getByAlbumNameContaining(albumNameLike);
        headers.add("desc", "Albums found successfully");
        headers.add("info", "Album Details");
        return ResponseEntity.ok().headers(headers).body(albumList);
    }

    @GetMapping("/albums/language/{language}")
    ResponseEntity<List<Album>> getByLanguage(@PathVariable("language") String language) {
        HttpHeaders headers = new HttpHeaders();
        List<Album> albumList = albumService.getByLanguage(language);
        headers.add("desc", "Albums found successfully");
        headers.add("info", "Album Details");
        return ResponseEntity.ok().headers(headers).body(albumList);
    }

    @GetMapping("/albums/label/{label}")
    ResponseEntity<List<Album>> getByLabel(@PathVariable("label") String label) {
        HttpHeaders headers = new HttpHeaders();
        List<Album> albumList = albumService.getByLabel(label);
        headers.add("desc", "Albums found successfully");
        headers.add("info", "Album Details");
        return ResponseEntity.ok().headers(headers).body(albumList);
    }

    @GetMapping("/albums/genre/{genre}")
    ResponseEntity<List<Album>> getByGenre(@PathVariable("genre") String genre) {
        HttpHeaders headers = new HttpHeaders();
        List<Album> albumList = albumService.getByGenre(genre);
        headers.add("desc", "Albums found successfully");
        headers.add("info", "Album Details");
        return ResponseEntity.ok().headers(headers).body(albumList);
    }

    @GetMapping("/albums/album/{album}/artist/{artist}")
    ResponseEntity<List<Album>> getByAlbumAndArtist(@PathVariable("album") String album, @PathVariable("artist") String artist) {
        HttpHeaders headers = new HttpHeaders();
        List<Album> albumList = albumService.getByAlbumAndArtist(album, artist);
        headers.add("desc", "Albums found successfully");
        headers.add("info", "Album Details");
        return ResponseEntity.ok().headers(headers).body(albumList);
    }


}
