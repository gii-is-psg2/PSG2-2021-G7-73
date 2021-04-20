package org.springframework.samples.petclinic.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.repository.DonationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DonationService {
	
private DonationRepository donationRepository ;
	
	
	@Autowired
	public DonationService(DonationRepository donationRepository) {
		this.donationRepository = donationRepository;
	}

	
	@Transactional
	public void saveDonation(Donation donation)  {
		donationRepository.save(donation);
	}

	@Transactional(readOnly=true)
	public Donation findById(int donationId)  {
		return donationRepository.findById(donationId);
	}
	

	
	@Transactional(readOnly=true)
	public Collection<Donation> findByCausa(Causa causa)  {
		return donationRepository.findByCausa(causa);
	}
}
