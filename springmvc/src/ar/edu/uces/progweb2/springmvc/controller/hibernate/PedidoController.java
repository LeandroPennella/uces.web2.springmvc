package ar.edu.uces.progweb2.springmvc.controller.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.springmvc.dao.PedidoDao;

@Controller
public class PedidoController {
	@Autowired
	private PedidoDao pedidoDao;
	
	@RequestMapping("/mostrarPedido")
	public ModelAndView getPedido(@RequestParam("id") long id)
	{
		return new ModelAndView("/views/hibernate/mostrarPedido.jsp","pedido",pedidoDao.get(id));
	}
	
}
