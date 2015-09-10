package ar.edu.uces.progweb2.springmvc.controller.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParametrosController {
	@RequestMapping("/tomarParametros") //http://localhost:8080/springmvc/tomarParametros.htm?parametroQuien=yo
	public String tomar(@RequestParam(value="parametroQuien", defaultValue="N/A", required=false  ) String quien)
	{
		System.out.println(quien);
		return "views/index.jsp";
	}
}

