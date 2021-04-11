package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.data.repository.Repository;


public interface CausaRepository extends Repository<Causa, Integer>{
	
	Collection<Causa> findAll() throws DataAccessException;
	
	Causa save(Causa entity);

}
