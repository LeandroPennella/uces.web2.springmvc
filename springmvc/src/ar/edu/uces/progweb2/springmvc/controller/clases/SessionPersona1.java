package ar.edu.uces.progweb2.springmvc.controller.clases;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.springmvc.model.Persona;
@SessionAttributes("persona")
@Controller
public class SessionPersona1 {
@RequestMapping(value="/crearPersonaEnSession")
public ModelAndView crear()
{
	Persona persona=new Persona("pepe",21);
	
	ModelAndView mv=new ModelAndView("views/session/mostrarPersona1.jsp");
	
	mv.addObject("persona", persona);
	return mv;
	}
}
