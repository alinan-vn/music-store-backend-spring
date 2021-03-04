package org.hcl.musicstore.service;

import java.util.Optional;

import org.hcl.musicstore.model.Album;
import org.hcl.musicstore.repository.AlbumCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
	private static Logger logger = LoggerFactory.getLogger(AlbumService.class);

	@Autowired
	AlbumCrudRepository albumCrudRepository;

	public Iterable<Album> getAllAlbum() {
		return albumCrudRepository.findAll();
	}
	
	public Album findAlbumById(int id) {
		return albumCrudRepository.findAlbumById(id);
	}

	public Optional<Album> getAlbum(int id) throws Exception {
		Optional<Album> album = albumCrudRepository.findById(id);

		if (album != null) {
			logger.info("album: " + album.toString());
			return album;
		}

		logger.error("album is null");
		throw new Exception("Album not found");
	}

	public Album findByAlbumName(String name) throws Exception {
		
		Album album = albumCrudRepository.findByAlbumName(name);
		
		if (album != null) {
			logger.info("album: " + album.toString());
			return album;
		}
		
		logger.error("album is null");
		throw new Exception("Album not found");
	}
	
	public Album saveAlbum(Album album) {
		return albumCrudRepository.save(album);
	}
	
	public void updateAlbum(Album album) {
		albumCrudRepository.save(album);
	}
	
	public boolean deleteAlbumById(Integer id) throws Exception{
		logger.info("deleting album with id: "+id);
		if(albumCrudRepository.existsById(id)) {
			albumCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("album is null");
		throw new Exception("Album not found");
    }

}
