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
    
    public Genre findGenreById(int id) {
    	return genreCrudRepository.findGenreById(id);
    }

    public Iterable<Genre> findAllGenre(){
        return genreCrudRepository.findAll();
    }

    public Optional<Genre> getGenreById(int id) throws Exception{
        Optional<Genre> genre = genreCrudRepository.findById(id);

        if(genre!= null) {
            logger.info("genre: "+genre.toString());
            return genre;
        }

        logger.error("genre is null");
        throw new Exception("genre with " + id + " doesn't exist");
    }
    
    public Genre saveAndUpdateGenre(Genre genre) {
		return genreCrudRepository.save(genre);
	}
	
	public boolean deleteGenreById(Integer id) throws Exception{
		logger.info("deleting genre with id: "+id);
		if(genreCrudRepository.existsById(id)) {
			genreCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("genre is null");
		throw new Exception("Genre not found");
    }
	
	public Genre updateGenre(Genre genre) {
		return genreCrudRepository.save(genre);
	}

}
