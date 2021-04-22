package org.springframework.samples.petclinic.web;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.service.CausaService;
import org.springframework.samples.petclinic.service.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donations")
public class DonationController {
//
//	@Autowired
//	DonationServiceImpl donationService;
//
//	@Autowired
//	CausaServiceImpl causaService;
//
//
//	@GetMapping(value = "/donations/new")
//	public String initCreationForm(Causa causa, ModelMap model) {
//		Donation donation = new Donation();
//		causa.addDonation(donation);
//		donation.setDate(LocalDate.now());
//		model.put("donation", donation);
//		return "donations/createOrUpdateDonationForm";
//	}
//
//	@PostMapping(value = "/donations/new")
//	public String processCreationForm(@ModelAttribute Causa causa, @Valid Donation donation, BindingResult result, ModelMap model) {
//		donation.setCausa(causa);
//		if (causaService.totalBudget(causa.getId())==causa.getObjetivo()){
//			result.rejectValue("client", "closed");
//			result.rejectValue("amount", "closed");
//		} 
//		if (result.hasErrors()) {
//			model.put("donation", donation);
//			return "donations/createOrUpdateDonationForm";
//		} else {
//			this.donationService.saveDonation(donation);
//			causa.addDonation(donation);
//
//
//			return "redirect:/causas";
//		}  
//
//	}
}
