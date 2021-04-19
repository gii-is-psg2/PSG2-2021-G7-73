package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Adoption;
import org.springframework.samples.petclinic.repository.AdoptionRepository;
import org.springframework.transaction.annotation.Transactional;

public class AdoptionService {
	
	private final AdoptionRepository adoptionRepository;

	
	@Autowired
	public AdoptionService(final AdoptionRepository adoptionRepository) {
		this.adoptionRepository = adoptionRepository;
	}
	
	@Transactional
	public void saveAdoption(final Adoption adoption) throws DataAccessException {
		this.adoptionRepository.save(adoption);
	}
	
	@Transactional(readOnly = true)
	public Adoption findAdoptionById(final int id) throws DataAccessException {
		return this.adoptionRepository.findById(id);
	}
	
}
