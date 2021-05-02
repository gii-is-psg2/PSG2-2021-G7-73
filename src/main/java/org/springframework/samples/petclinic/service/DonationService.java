package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.repository.DonationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DonationService {
	
	private final DonationRepository donationRepository ;

	@Autowired
	private final CausaService causaService;
	
	
	@Autowired
	public DonationService(final DonationRepository donationRepository,final CausaService causaService) {
		this.donationRepository = donationRepository;
		this.causaService = causaService;
	}

	
	@Transactional
	public void saveDonation(final Donation donation, final int causaId)  {
		final Causa causa = this.causaService.findById(causaId);
		this.causaService.addDonation(causa, donation);
		this.donationRepository.save(donation);
	}

	@Transactional(readOnly=true)
	public Donation findById(final int donationId)  {
		return this.donationRepository.findById(donationId);
	}
	

	
	@Transactional(readOnly=true)
	public Collection<Donation> findByCausa(final Causa causa)  {
		return this.donationRepository.findByCausa(causa.getId());
	}
}
