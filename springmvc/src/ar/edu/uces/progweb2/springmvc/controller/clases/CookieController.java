package ar.edu.uces.progweb2.springmvc.controller.clases;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CookieController {
	@RequestMapping(value="/setearCookie")
	public ModelAndView setearCookie(HttpServletResponse r)
	{
		Cookie c=new Cookie("colorPantalla","#FF0033");
		c.setMaxAge(10);		//en segundos? //-1 de sesion //0 para borrarla
		r.addCookie(c);
		return new ModelAndView("/views/cookies/mostrarCookies.jsp");
	}
	
	@RequestMapping(value="/reSetearCookie")
	public ModelAndView reSetearCookie(@CookieValue (value="colorPantalla", required=false)String valorCookie, HttpServletResponse r)
	{
		if(valorCookie==null)
		{valorCookie="#00FF00";}
		return new ModelAndView("/views/cookies/mostrarColorConCookies.jsp", "color", valorCookie);
	}
}
