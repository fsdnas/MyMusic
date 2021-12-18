package com.mymusic.exceptions;

public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException(String message) {
        super(message);
    }

    public ArtistNotFoundException() {
    }
}
