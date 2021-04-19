package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Adoption;

public interface AdoptionRepository extends Repository<Adoption, Integer> {

	
	Adoption findById(int id) throws DataAccessException;

	void save(Adoption adoption) throws DataAccessException;
}
