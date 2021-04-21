package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


public interface CausaRepository extends Repository<Causa, Integer>{
	
	Collection<Causa> findAll() throws DataAccessException;
	
	Causa save(Causa entity);

	@Query("SELECT causa from Causa causa WHERE causa.id =:id")
	public Causa findById(@Param("id") int id);

}
