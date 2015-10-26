package ar.edu.uces.progweb2.springmvc.controller.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.uces.progweb2.springmvc.dao.PedidoDao;
import ar.edu.uces.progweb2.springmvc.model.Pedido;

@Controller
public class PedidoController {

	private PedidoDao pedidoDao;
	@Autowired
	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}
	@RequestMapping("/mostrarPedido")
	public ModelAndView getPedido(@RequestParam("id") long id)
	{
		Pedido pedido=pedidoDao.get(id);
		return new ModelAndView("/views/hibernate/mostrarPedido.jsp","pedido",pedido);
	}
	
}
