package org.hcl.musicstore.controller;

import java.util.Optional;

import org.hcl.musicstore.model.Song;
import org.hcl.musicstore.service.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SongController {
	private static Logger logger = LoggerFactory.getLogger(SongController.class);
	
	@Autowired
	SongService songService;

	@PostMapping("/savesong")
	public ResponseEntity<Song> saveSong(@RequestBody Song song){
		songService.saveAndUpdateSong(song);
		return new ResponseEntity<Song>(HttpStatus.OK);
	}
	
	@GetMapping("/song")
	public Iterable<Song> getAllSongDetails(){
		return songService.findAllSong();
	}
	
	@GetMapping("/song/{id}")
	public ResponseEntity<Song> getSongById(@PathVariable Integer id) throws Exception{
		Optional<Song> song = songService.getSongById(id);
		
		return song.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@GetMapping("/songname/{name}")
	public Song searchSongByName(@PathVariable String name) throws Exception {
		return songService.findBySongName(name);
	}
	
	@DeleteMapping("/deletesong/{id}")
	public ResponseEntity<String> deleteSong(@PathVariable Integer id) throws Exception{
		logger.info("Deleting song with id: "+ id);
		boolean isRemoved = songService.deleteSongById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
	@PutMapping("/updatesong/{id}")
	public ResponseEntity<Song> updateSong(@PathVariable Integer id, @RequestBody Song song) throws Exception{
		logger.info("Updating song to: "+ song.toString());
		
		Song editedSong = songService.findSongById(id);
		editedSong.setArtist(song.getArtist());
		editedSong.setImage(song.getImage());
		editedSong.setPrice(song.getPrice());
		editedSong.setSongName(song.getSongName());
		songService.updateSong(editedSong);
		
		return new ResponseEntity<Song>(HttpStatus.OK);
	}
	
}
