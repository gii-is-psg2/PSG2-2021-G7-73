package org.springframework.samples.petclinic.web;

import java.util.Collection;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Causa;
import org.springframework.samples.petclinic.service.CausaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/causas")
public class CausaController {
	
	@Autowired
	CausaService causaService;
	

	@GetMapping
	public String listCausas(ModelMap model) {
		String vista = "causas/listCausa";
		Collection<Causa> Causa = causaService.findAll();
		model.addAttribute("causas", Causa);
		return vista;
	}

	
	@PostMapping(path="/save")
	public String guardarCausa(@Valid Causa causa, BindingResult result, ModelMap modelmap) {
		String vista = "causas/listCausa";
		if(result.hasErrors()) {
			modelmap.addAttribute("causa", causa);
			return "causas/editCausa";
		}else {
			causaService.save(causa);
			modelmap.addAttribute("message", "Causa guardada correctamente");
			vista = listCausas(modelmap);
		}
		return vista;
	}
	
	@GetMapping(path="/new")
	public String crearCausa(ModelMap modelmap) {
		String vista = "causas/editCausa";
		modelmap.addAttribute("causa", new Causa());
		return vista;
	}
	
	
	@GetMapping("/{causaId}")
	public ModelAndView showCausa(@PathVariable("causaId") int causaId) {
		ModelAndView mav = new ModelAndView("causas/causaDetails");
		mav.addObject(this.causaService.findCausaById(causaId));
		return mav;
	}

}
