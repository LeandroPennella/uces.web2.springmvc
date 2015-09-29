package ar.edu.uces.progweb2.springmvc.controller.clases;



	import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


	@Controller
	public class SetearLocaleController {
		@Autowired
		private SessionLocaleResolver localeResolver;
		
		@RequestMapping(value = "/holamundo")
		public String testeo(HttpServletRequest rs, HttpServletRequest request, HttpServletResponse response) {
			localeResolver.setLocale(request, response, new Locale("es_AR") );
			System.out.println("MyController - hola mundo");
			System.out.println("mensaje: "+rs.getAttribute("mensaje"));
			return "/views/holamundo.jsp";
		}

	}