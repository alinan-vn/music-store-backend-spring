package org.hcl.musicstore.controller;

import java.util.Optional;

import org.hcl.musicstore.model.Album;
import org.hcl.musicstore.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AlbumController {
	
	@Autowired
	AlbumService albumService;

	@GetMapping("/album")
	public Iterable<Album> getAlbumDetails(){

		return albumService.getAllAlbum();
	}
	
	@GetMapping("/album/{id}")
	public ResponseEntity<?> getAlbumById(@PathVariable Integer id) throws Exception{
		Optional<Album> album = albumService.getAlbum(id);
		
		return album.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@GetMapping("/albumname/{name}")
	public Album searchAlbumByName(@PathVariable String name) throws Exception {
		return albumService.findByAlbumName(name);
	}
	
}
