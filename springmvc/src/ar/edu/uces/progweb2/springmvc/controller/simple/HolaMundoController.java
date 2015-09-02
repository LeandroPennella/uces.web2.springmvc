package ar.edu.uces.progweb2.springmvc.controller.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaMundoController {
	@RequestMapping(value = "/holamundo")
	public String testeo() {
		System.out.println("MyController - hola mundo");
		return "/views/holamundo.jsp";
	}
}
