package org.springframework.samples.petclinic.service;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.samples.petclinic.repository.CausaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CausaService {
	
	private CausaRepository causaRepo;
	
	
	@Autowired
	public CausaService(CausaRepository causaRepo) {
		this.causaRepo = causaRepo;
	}


	
	@Transactional(readOnly=true)
	public Collection<Causa> findAll() {
		return causaRepo.findAll();
	}
	
	
	@Transactional
	public void save(@Valid Causa Causa) {
		causaRepo.save(Causa);

	}
	

}
