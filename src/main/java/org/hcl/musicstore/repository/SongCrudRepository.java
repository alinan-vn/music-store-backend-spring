package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongCrudRepository extends CrudRepository<Song, Integer> {
	public Song findSongByName(String name);
}
