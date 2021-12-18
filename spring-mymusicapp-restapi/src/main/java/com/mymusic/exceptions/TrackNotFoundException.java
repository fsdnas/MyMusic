package com.mymusic.exceptions;

public class TrackNotFoundException extends RuntimeException {
    public TrackNotFoundException(String message) {
        super(message);
    }

    public TrackNotFoundException() {
    }
}
