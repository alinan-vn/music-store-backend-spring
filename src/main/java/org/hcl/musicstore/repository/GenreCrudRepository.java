package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreCrudRepository extends CrudRepository<Genre, Integer> {
	public Genre findGenreById(Integer id);
}
