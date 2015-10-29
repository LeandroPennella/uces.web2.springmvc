package ar.edu.uces.progweb2.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.springmvc.model.Something;

//todos los metodos son transaccionales
//cuando arranca el metodo, abre transaccion > si sale por una runtimeexception rollbackea, sino sale bien comitean
@Transactional(readOnly = true)

@Component
public class SomethingDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
 		this.sessionFactory = sessionFactory;
	}

	public Something get(long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Something out = (Something) session.get(Something.class, id); //solo para traer por id, para queriar hay otras cosas
		// session.close();
		return out;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Something something) {
		Session session = sessionFactory.getCurrentSession();
		// Transaction tx = session.beginTransaction();
		// try {
		
		//guarda el id en la instancia
		session.saveOrUpdate(something);
		
		// tx.commit();
		// } catch (RuntimeException e) {
		// tx.rollback();
		// throw e;
		// } finally {
		// session.close();
		// }
	}

}
