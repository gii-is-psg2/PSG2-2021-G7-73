package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


public interface CausaRepository extends Repository<Causa, Integer>{
	
	Collection<Causa> findAll() throws DataAccessException;
	
	
	Causa findById(int causeId);
	
	Causa save(Causa entity);
	
	Double totalBudget(Causa causa);
	

    
	 
}
