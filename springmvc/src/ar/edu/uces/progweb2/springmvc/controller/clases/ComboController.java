package ar.edu.uces.progweb2.springmvc.controller.clases;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ComboController {
	@RequestMapping(value="/mostrarCombo")
	public String init()
	{
		return	"views/mostrarCombo.jsp";
	}
}
