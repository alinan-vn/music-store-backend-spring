package org.hcl.musicstore.service;



import org.hcl.musicstore.model.Genre;

import org.hcl.musicstore.repository.GenreCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {
    private static Logger logger = LoggerFactory.getLogger(GenreService.class);

    @Autowired
    GenreCrudRepository genreCrudRepository;

    public Iterable<Genre> getAllGenre(){
        return genreCrudRepository.findAll();
    }

    public Optional<Genre> getGenre(int id) throws Exception{
        Optional<Genre> genre = genreCrudRepository.findById(id);

        if(genre!= null) {
            logger.info("genre: "+genre.toString());
            return genre;
        }

        logger.error("genre is null");
        throw new Exception("genre with " + id + " doesn't exist");

    }

}
