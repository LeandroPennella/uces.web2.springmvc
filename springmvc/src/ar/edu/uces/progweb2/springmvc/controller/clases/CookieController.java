package ar.edu.uces.progweb2.springmvc.controller.clases;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CookieController {
	@RequestMapping(value="/setearCookie")
	public ModelAndView setearCookie(@CookieValue (value="a", required=false)String valor, HttpServletResponse r)
	{
		
		Cookie c=new Cookie("colorPantalla","#00FF33");
		//c.setMaxAge(0);		//en segundos? //-1 de sesion //0 para borrarla

		r.addCookie(c);
		
		
		return new ModelAndView("/views/cookies/mostrarCookies.jsp");
	}
}
