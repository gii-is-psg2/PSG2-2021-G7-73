package org.springframework.samples.petclinic.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.repository.CausaRepository;
import org.springframework.samples.petclinic.repository.DonationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CausaService {
	
	private CausaRepository causaRepo;
	private DonationRepository donationRepo;
	
	
	@Autowired
	public void CausaServiceImpl(CausaRepository causaRepo) {
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
	
	@Transactional(readOnly=true)
	public Causa findById(int causeId) {
		return causaRepo.findById(causeId);
	}
	
	
	@Transactional
	public Double totalBudget(Causa causa)  {
		Collection<Donation> donaciones = donationRepo.findByCausa(causa);
		double finl=0;
		for(Donation e:donaciones) {
			finl+=e.getAmount();
		}
		return finl;
	}

	@Transactional(readOnly=true)
	public Collection<Donation> findDonations(Causa causa)  {
		return donationRepo.findByCausa(causa);
	}
	
	
	
	@Transactional
	public List<Double> findDonationsByCauses(List<Causa> causes) {
		List<Double> res=new ArrayList<>();
		for(Causa c:causes) {
			Double res1=0.;
				for(Donation d:this.findDonationsByCausa(c)) {
					res1+=d.getAmount();
			
					}
			res.add(res1);
		}
		return res;
	}
	private Collection<Donation> findDonationsByCausa(Causa id) {
		return donationRepo.findByCausa(id);
	}
	
}
