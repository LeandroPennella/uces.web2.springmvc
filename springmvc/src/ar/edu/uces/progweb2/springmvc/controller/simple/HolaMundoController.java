package ar.edu.uces.progweb2.springmvc.controller.simple;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HolaMundoController {
	
	@RequestMapping(value = "/holamundo")
	public String testeo(HttpServletRequest rs) {
		System.out.println("MyController - hola mundo");
		System.out.println("mensaje: "+rs.getAttribute("mensaje"));
		return "/views/holamundo.jsp";
	}

}
