package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.AdoptionService;
import org.springframework.samples.petclinic.service.AuthoritiesService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdoptionController {


	
	private final AdoptionService adoptionService;


	
	@Autowired
	public AdoptionController(final AdoptionService adoptionService ,
		final UserService userService, final AuthoritiesService authoritiesService) {
		this.adoptionService = adoptionService;
		
	}

	
	@InitBinder
	public void setAllowedFields(final WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}	
	
	
	@GetMapping(value = "/adoptions/{petId}/newAdoption")
	public String setAdoption(@PathVariable("petId") final int petId) {
		this.adoptionService.createAdoption(petId);
		return "redirect:/adoptions/adoptionList";
	}
	
	@GetMapping(value = "/adoptions/{petId}/{ownerId}/getAdoption")
	public String getAdoption(@PathVariable("petId") final int petId,@PathVariable("ownerId") final int ownerId) {
		this.adoptionService.saveAdoption(petId,ownerId);
		return "redirect:/adoptions/adoptionList";
	}
	
//	@GetMapping(value = "/adoptions/new")
//	public String initCreationForm(final Map<String, Object> model) {

	
//	@GetMapping(value = "/adoptions/{adoptionId}/edit")
//	public String initUpdateAdoptionForm(@PathVariable("adoptionId") final int adoptionId, final Model model) {


	@GetMapping(value ="/adoptions")
	public ModelAndView adoptionList(final Map<String, Object> model) {
		final ModelAndView res=new ModelAndView("adoptions/adoptionList");
		model.put("adoptions", this.adoptionService.getAdoptions());
		return res;
	}
	

}


