package org.hcl.musicstore.controller;

import java.util.Optional;

import org.hcl.musicstore.model.Album;
import org.hcl.musicstore.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AlbumController {
	private static Logger logger = LoggerFactory.getLogger(AlbumController.class);
	
	@Autowired
	AlbumService albumService;

	@PostMapping("/savealbum")
	public ResponseEntity<Album> saveAlbum(@RequestBody Album album){
		albumService.saveAlbum(album);
		return new ResponseEntity<Album>(HttpStatus.OK);
	}
	
	@GetMapping("/album")
	public Iterable<Album> getAlbumDetails(){
		return albumService.getAllAlbum();
	}
	
	@GetMapping("/album/{id}")
	public ResponseEntity<Album> getAlbumById(@PathVariable Integer id) throws Exception{
		Optional<Album> album = albumService.getAlbum(id);
		
		return album.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@GetMapping("/albumname/{name}")
	public Album searchAlbumByName(@PathVariable String name) throws Exception {
		return albumService.findByAlbumName(name);
	}
	
	@DeleteMapping("/deletealbum/{id}")
	public ResponseEntity<String> deleteAlbum(@PathVariable Integer id) throws Exception{
		logger.info("Deleting album with id: "+ id);
		boolean isRemoved = albumService.deleteAlbumById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
	@PutMapping("/updatealbum/{id}")
	public ResponseEntity<Album> updateAlbum(@PathVariable Integer id, @RequestBody Album album) throws Exception{
		logger.info("Updating album to: "+ album.toString());
		
		Album editedAlbum = albumService.findAlbumById(id);
		editedAlbum.setAlbumName(album.getAlbumName());
		albumService.updateAlbum(editedAlbum);
		
		return new ResponseEntity<Album>(HttpStatus.OK);
	}

}
