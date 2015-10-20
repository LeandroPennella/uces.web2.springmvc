package ar.edu.uces.progweb2.springmvc.controller.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {
	@RequestMapping(value = "/test")
	public String test() {
		System.out.println("MyController - test");
		return "/views/test.jsp";
	}

}
