package org.springframework.samples.petclinic.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.repository.CausaRepository;
import org.springframework.samples.petclinic.repository.DonationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CausaService {
	
	private final CausaRepository causaRepo;
	private final DonationRepository donationRepo;
	
	
	@Autowired
	public CausaService(final CausaRepository causaRepo,final DonationRepository donationRepo) {
		this.causaRepo = causaRepo;
		this.donationRepo = donationRepo;
	}

	
	@Transactional(readOnly=true)
	public Collection<Causa> findAll() {
		return this.causaRepo.findAll();
	}
	
	
	@Transactional(readOnly = true)
	public Causa findCausaById(final int id) throws DataAccessException {
		return this.causaRepo.findById(id);
	}
	
	
	@Transactional
	public void save(@Valid final Causa causa) {
		this.causaRepo.save(causa);

	}
	
	@Transactional(readOnly=true)
	public Causa findById(final int causeId) {
		return this.causaRepo.findById(causeId);
	}
	
	
	@Transactional
	public Double totalBudget(final Integer causaId)  {
		final Collection<Donation> donaciones = this.donationRepo.findByCausa(causaId);
		double finl=0;
		for(final Donation e:donaciones) {
			finl+=e.getAmount();
		}
		return finl;
	}

	@Transactional(readOnly=true)
	public Collection<Donation> findDonations(final Causa causa)  {
		return this.donationRepo.findByCausa(causa.getId());
	}
	
	
	
	@Transactional
	public List<Double> findDonationsByCauses(final List<Causa> causes) {
		final List<Double> res=new ArrayList<>();
		for(final Causa c:causes) {
			Double res1=0.;
				for(final Donation d:this.findDonationsByCausa(c)) {
					res1+=d.getAmount();
			
					}
			res.add(res1);
		}
		return res;
	}
	private Collection<Donation> findDonationsByCausa(final Causa causa) {
		return this.donationRepo.findByCausa(causa.getId());
	}


	public void addDonation(final Causa causa, final Donation donation) {
		if(causa.getTotalBudget()==null) {
			causa.setTotalBudget(donation.getAmount());
		}else {
			causa.setTotalBudget(causa.getTotalBudget() + donation.getAmount());
		}
	}
	
}
