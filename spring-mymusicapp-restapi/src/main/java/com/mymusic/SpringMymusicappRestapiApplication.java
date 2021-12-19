package com.mymusic;
import com.mymusic.model.*;
import com.mymusic.service.IAlbumService;

import com.mymusic.service.IArtistService;
import com.mymusic.service.ITracksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class SpringMymusicappRestapiApplication implements CommandLineRunner {


    @Autowired
    private IAlbumService albumService;

    @Autowired
    private IArtistService artistService;

    @Autowired
    private ITracksService tracksService;

    public static void main(String[] args) {
        SpringApplication.run(SpringMymusicappRestapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//
//        Genre genre = new Genre("Classic");
//
//        Artist artist1 = new Artist("Anirudh Ravichander", "Anirudh Ravichander (born 16 October 1990), also known mononymously as Anirudh, is an Indian film composer", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Anirudh_Ravichander_at_Audi_Ritz_Style_Awards_2017.jpg/330px-Anirudh_Ravichander_at_Audi_Ritz_Style_Awards_2017.jpg", 8);
//        Artist artist2 = new Artist("Vidyasagar", "Vidyasagar is an Indian composer, musician and singer who works predominantly in the Malayalam ", "https://upload.wikimedia.org/wikipedia/commons/1/1f/VidyaSagar.jpg", 50);
//        Artist artist3 = new Artist(" Gana Balachandar", "Gana Balachandar is an actor, known for Bigil (2019), Anirudh Ravichander & Gana Balachandar", "https://en.wikipedia.org/wiki/File:Jasleen_Royal_performing_in_Rajasthan_(cropped).jpg", 56);
//        Artist artist4 = new Artist("Yuvan Shankar Raja", "Abdul Haliq, (born Yuvan Shankar Raja on 31 August 1979) is an Indian film score and soundtrack composer and singer-songwriter.", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Yuvan_Shankar_Raja_exclusive_HQ_Photos_Silverscreen.jpg/330px-Yuvan_Shankar_Raja_exclusive_HQ_Photos_Silverscreen.jpg", 32);
//        Artist artist5 = new Artist("Arivu", "Arivarasu Kalainesan, more commonly known as Arivu, is an Indian Tamil rapper, lyricist, and playback singer", "https://static.toiimg.com/photo/msid-83690259/83690259.jpg?343134", 60);
//        Artist artist6 = new Artist("Santhosh Narayanan", "Santhosh Narayanan is an Indian film composer and musician in the Tamil film industry. He made his debut as a film composer in the 2012 Tamil film Attakathi.", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Santhosh_Narayanan_and_his_Wife_at_%E2%80%98Kadugu%E2%80%99_Movie_Premiere_%28cropped%29.jpg/330px-Santhosh_Narayanan_and_his_Wife_at_%E2%80%98Kadugu%E2%80%99_Movie_Premiere_%28cropped%29.jpg", 20);
//
//        Set<Artist> artists1 = new HashSet<>(Arrays.asList(artist1, artist2, artist3));
//        Set<Artist> artists2 = new HashSet<>(Arrays.asList(artist1, artist4));
//        Set<Artist> artists3 = new HashSet<>(Arrays.asList(artist3, artist2, artist1));
//        Set<Artist> artists4 = new HashSet<>(Arrays.asList(artist1, artist5));
//        Set<Artist> artists5 = new HashSet<>(Arrays.asList(artist2, artist1));
//        Set<Artist> artists6 = new HashSet<>(Arrays.asList(artist1, artist6));
//
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String stringDate1 = "05-06-2020";
//        LocalDate releaseDate1 = LocalDate.parse(stringDate1, formatter);
//
//        String stringDate2 = "11-05-2020";
//        LocalDate releaseDate2 = LocalDate.parse(stringDate2, formatter);
//
//        String stringDate3 = "03-05-2020";
//        LocalDate releaseDate3 = LocalDate.parse(stringDate3, formatter);
//
//
//        Tracks track1 = new Tracks("Master the Blaster", artists1, 4.0, releaseDate2, "Anirudh Ravichander");
//        Tracks track2 = new Tracks("Vaathi Kabaddi", artists2, 4.4, releaseDate1, "Anirudh Ravichander");
//        Tracks track3 = new Tracks("Kutti Story", artists3, 4.5, releaseDate2, "Anirudh Ravichander");
//        Tracks track4 = new Tracks("Vaathi Coming", artists4, 4.2, releaseDate1, "Anirudh Ravichander");
//        Tracks track5 = new Tracks("Andha Kanna Paathaakaa", artists5, 4.5, releaseDate3, "Anirudh Ravichander");
//        Tracks track6 = new Tracks("Vaathi Raid", artists6, 4.5, releaseDate3, "Anirudh Ravichander");
//        Tracks track7 = new Tracks("Quit Pannuda", artists6, 4.5, releaseDate3, "Anirudh Ravichander");
//        Tracks track8 = new Tracks("Polakattum Para Para", artists6, 4.5, releaseDate3, "Anirudh Ravichander");
//        Tracks track9 = new Tracks("Pona Pogattum", artists6, 4.5, releaseDate3, "Anirudh Ravichander");
//
//        Set<Tracks> tracksSet = new HashSet<>(Arrays.asList(track1, track2, track3, track4, track5, track6, track7, track8, track9));
//        Album album = new Album("Master", tracksSet.size(), Language.TAMIL, "https://en.wikipedia.org/wiki/File:Master_2021_poster.jpg", "Master is a 2021 Indian Tamil-language action thriller film written and directed by Lokesh Kanagaraj.", genre, Label.SONY, tracksSet);

//        albumService.addAlbum(album);

    }
}
