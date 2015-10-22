package ar.edu.uces.progweb2.springmvc.controller.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.springmvc.dao.PedidoDao;
import ar.edu.uces.progweb2.springmvc.model.Pedido;

@Controller
public class PedidoController {
	@Autowired
	private PedidoDao pedidoDao;
	
	@RequestMapping("/mostrarPedido")
	public ModelAndView getPedido(@RequestParam("id") long id)
	{
		PedidoDao pedidoDao=new PedidoDao();
		Pedido pedido=null;
		try {
			pedido=pedidoDao.get(id);
		} catch (Exception e) {
			// TODO: handle exception
			return new ModelAndView("/views/hibernate/mostrarPedido.jsp");
		}
		
		return new ModelAndView("/views/hibernate/mostrarPedido.jsp","pedido",pedido);
	}
	
}
