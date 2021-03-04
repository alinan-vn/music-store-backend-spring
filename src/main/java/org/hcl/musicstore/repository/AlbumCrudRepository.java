package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Album;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumCrudRepository extends CrudRepository<Album, Integer> {
	public Album findByAlbumName(String name);
	public Album findAlbumById(Integer id);
}
