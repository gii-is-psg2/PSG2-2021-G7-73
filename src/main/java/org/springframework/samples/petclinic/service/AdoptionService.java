package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Adoption;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.AdoptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdoptionService {
	
	private final AdoptionRepository adoptionRepository;
	private final PetService petService;
	private final OwnerService ownerService;
	
	@Autowired
	public AdoptionService(final AdoptionRepository adoptionRepository,
		final PetService petService,final OwnerService ownerService) {
		this.adoptionRepository = adoptionRepository;
		this.petService= petService;
		this.ownerService =ownerService;
	}
	
	@Transactional
	public void saveAdoption( final int petId, final int ownerId) throws DataAccessException {
		final List<Adoption> adopciones=this.adoptionRepository.findByPetId(petId);
		Adoption adoption=new Adoption();
		for(int i=0;i<adopciones.size();i++) {
			if(adopciones.get(i).getActualOwner()==null) {
				adoption=adopciones.get(i);
			}
		}
		adoption.setActualOwner(this.ownerService.findOwnerById(ownerId));
		this.petService.findPetById(petId).setOwner(adoption.getActualOwner());
		
		this.adoptionRepository.save(adoption);
	}
	
	@Transactional
	public void createAdoption(final Integer petId) throws DataAccessException {
		final Pet pet=this.petService.findPetById(petId);
		final Adoption adoption=new Adoption();
		adoption.setPet(pet);
		adoption.setPreviousOwner(pet.getOwner());
		
		this.adoptionRepository.save(adoption);
	}
	
	@Transactional(readOnly = true)
	public Adoption findAdoptionById(final int id) throws DataAccessException {
		return this.adoptionRepository.findById(id);
	}

	public Collection<Adoption> getAdoptions(){
		return this.adoptionRepository.getAdoptions();
	}
	
}
