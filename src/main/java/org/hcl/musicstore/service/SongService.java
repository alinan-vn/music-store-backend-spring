package org.hcl.musicstore.service;

import org.hcl.musicstore.model.Song;
import org.hcl.musicstore.repository.SongCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService {
    private static Logger logger = LoggerFactory.getLogger(SongService.class);

    @Autowired
    SongCrudRepository songCrudRepository;

    public Optional<Song> getSong(int id) throws Exception {
        Optional<Song> song = songCrudRepository.findById(id);
        if(song != null){
            logger.info("song: " + song.toString());
            return song;
        }
        logger.error("song is null");
        throw new Exception("song with " + id + " doesn't exist!");
    }


}
