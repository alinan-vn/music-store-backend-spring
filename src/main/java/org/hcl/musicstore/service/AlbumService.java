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
	
	public Optional<Album> getAlbum(int id) throws Exception {
		Optional<Album> album = albumCrudRepository.findById(id);
		
		if(album != null) {
			logger.info("album: "+album.toString());
			return album;
		}
		
		logger.error("album is null");
		throw new Exception("Album not found");
	}
}