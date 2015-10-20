package ar.edu.uces.progweb2.springmvc.controller.clases;

import java.util.*;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.springmvc.model.*;

@Controller
public class PersonaController {

	@RequestMapping("/listarPersonas")
	public ModelAndView crearLista()
	{
		List<Persona>personas=new ArrayList<Persona>();
		personas.add(new Persona("pepe"));
		personas.add(new Persona("jose"));
		personas.add(new Persona("lean"));
		personas.add(new Persona("jorge"));
		ModelAndView mv=new ModelAndView("/views/listadoDePersonas.jsp");
		mv.addObject("personas", personas);
		return mv;
	}
}
