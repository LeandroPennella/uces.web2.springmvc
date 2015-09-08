package ar.edu.uces.progweb2.springmvc.controller.simple;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FechaController {
	@RequestMapping("/mostrarFecha")
	public ModelAndView generarFecha()
	{
		Date fecha=new Date();
		ModelAndView mv=new ModelAndView("/views/internacionalizacionFecha.jsp");
		mv.addObject("fecha", fecha);
		return mv;
	}
}
