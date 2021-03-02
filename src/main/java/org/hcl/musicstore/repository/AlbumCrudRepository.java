package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumCrudRepository extends CrudRepository<Album, Integer> {
}
