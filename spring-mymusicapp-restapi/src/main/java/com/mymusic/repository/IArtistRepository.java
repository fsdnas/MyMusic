package com.mymusic.repository;

import com.mymusic.exceptions.ArtistNotFoundException;
import com.mymusic.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArtistRepository extends JpaRepository<Artist, Integer> {

    List<Artist> findByArtistRank(int rank) throws ArtistNotFoundException;
}
