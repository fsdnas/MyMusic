package com.mymusic;


import com.mymusic.service.IAlbumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringMymusicappRestapiApplication implements CommandLineRunner {

    @Autowired
    private IAlbumService albumService;


    public static void main(String[] args) {
        SpringApplication.run(SpringMymusicappRestapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
