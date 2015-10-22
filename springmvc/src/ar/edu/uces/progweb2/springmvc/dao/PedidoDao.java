package ar.edu.uces.progweb2.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.springmvc.model.Pedido;

//todos los metodos son transaccionales
//cuando arranca el metodo, abre transaccion > si sale por una runtimeexception rollbackea, sino sale bien comitean
@Transactional(readOnly = true)

@Component
public class PedidoDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Pedido get(long id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Pedido out = null;
		try {
			out= (Pedido) session.get(Pedido.class, id);//load no tira excepcion si no lo encuentra	
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("no se pudo traer el registro "+id+" | "+ e.getMessage() );
		}
		return out;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Pedido pedido) {
		Session session = sessionFactory.getCurrentSession();
		
		//guarda el id en la instancia
		session.saveOrUpdate(pedido);
		
	}

}
