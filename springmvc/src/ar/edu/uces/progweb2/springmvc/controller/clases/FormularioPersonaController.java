package ar.edu.uces.progweb2.springmvc.controller.clases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.springmvc.model.Persona;
import ar.edu.uces.progweb2.springmvc.validator.PersonaValidator;

@Controller
public class FormularioPersonaController {
	
	@Autowired
	private PersonaValidator personaValidator;


	/*
	public void setPersonValidator(PersonValidator personValidator) {
		this.personaValidator = personValidator;
	}*/
	
	@RequestMapping(value = "/formulario")
	public ModelAndView init(ModelMap model) {
		//model.addAttribute("persona", new Persona());
		ModelAndView modelAndView=new ModelAndView ("/views/persona/formulario.jsp");
		modelAndView.addObject("persona", new Persona());
		return modelAndView;
		//return new ModelAndView("/views/persona/formulario.jsp");
	}
	
	@RequestMapping(value = "/procesar", method = RequestMethod.POST)
	public ModelAndView process(@ModelAttribute("persona") Persona persona, BindingResult result, SessionStatus status) {
		this.personaValidator.validate(persona, result);
		if (result.hasErrors()) {
			return new ModelAndView("/views/persona/formulario.jsp");
		}
		status.setComplete();
		return new ModelAndView("/views/persona/resultado.jsp", "persona", persona);
	}
}
