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
	public String listCausas(final ModelMap model) {
		final String vista = "causas/listCausa";
		final Collection<Causa> Causa = this.causaService.findAll();
		model.addAttribute("causas", Causa);
		return vista;
	}

	
	@PostMapping(path="/save")
	public String guardarCausa(@Valid final Causa causa, final BindingResult result, final ModelMap modelmap) {
		String vista = "causas/listCausa";
		if(result.hasErrors()) {
			modelmap.addAttribute("causa", causa);
			return "causas/editCausa";
		}else {
			this.causaService.save(causa);
			modelmap.addAttribute("message", "Causa guardada correctamente");
			vista = this.listCausas(modelmap);
		}
		return vista;
	}
	
	@GetMapping(path="/new")
	public String crearCausa(final ModelMap modelmap) {
		final String vista = "causas/editCausa";
		modelmap.addAttribute("causa", new Causa());
		return vista;
	}
	
	
	@GetMapping("/{causaId}")
	public ModelAndView showCausa(@PathVariable("causaId") final int causaId) {
		final ModelAndView mav = new ModelAndView("causas/causaDetails");
		mav.addObject(this.causaService.findById(causaId));
		return mav;
	}

}
