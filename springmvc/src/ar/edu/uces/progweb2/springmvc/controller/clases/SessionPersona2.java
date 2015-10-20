package ar.edu.uces.progweb2.springmvc.controller.clases;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.springmvc.model.Persona;


@SessionAttributes("persona")
@Controller
public class SessionPersona2 {
	@RequestMapping(value = "/tomarPersonaDeSession")
	public ModelAndView tomarPersona(@ModelAttribute("persona") Persona persona)
	// public ModelAndView tomarPersona(ModelMap modelMap)
	{
		// Persona persona=(Persona)modelMap.get("persona");
		ModelAndView mv = new ModelAndView("views/session/mostrarPersona2.jsp");
		mv.addObject("persona2", persona);
		return mv;
	}
}
