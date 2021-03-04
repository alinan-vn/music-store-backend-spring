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

	public Iterable<Song> findAllSong() {
		return songCrudRepository.findAll();
	}

	public Optional<Song> findSongById(int id) throws Exception {
		Optional<Song> song = songCrudRepository.findById(id);
		if (song != null) {
			logger.info("song: " + song.toString());
			return song;
		}
		logger.error("song is null");
		throw new Exception("song with " + id + " doesn't exist!");
	}

	public Song saveAndUpdateSong(Song song) {
		return songCrudRepository.save(song);

	}

	public Song findBySongName(String name) throws Exception {
		
		Song song = songCrudRepository.findSongBySongName(name);
		if (song != null) {
			logger.info("album: " + song.toString());
			return song;
		}
		
		logger.error("song is null");
		throw new Exception("Song not found");
	}
	
	public boolean deleteSongById(Integer id) throws Exception{
		logger.info("deleting song with id: "+id);
		if(songCrudRepository.existsById(id)) {
			songCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("song is null");
		throw new Exception("Song not found");
    }

}
