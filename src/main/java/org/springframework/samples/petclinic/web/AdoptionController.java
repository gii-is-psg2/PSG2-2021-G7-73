package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.AdoptionService;
import org.springframework.samples.petclinic.service.AuthoritiesService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class AdoptionController {


	private static final String VIEWS_ADOPTION_CREATE_OR_UPDATE_FORM = "adoptions/createOrUpdateAdoptionForm";
	
	private final AdoptionService adoptionService;

	
	@Autowired
	public AdoptionController(final AdoptionService adoptionService, final UserService userService, final AuthoritiesService authoritiesService) {
		this.adoptionService = adoptionService;
	}

	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}	
}
