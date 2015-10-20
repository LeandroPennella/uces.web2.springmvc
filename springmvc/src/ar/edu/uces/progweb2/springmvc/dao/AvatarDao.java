package ar.edu.uces.progweb2.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.springmvc.model.Avatar;

@Transactional(readOnly = true)
@Component
public class AvatarDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Avatar get(long id) {
		Session session = sessionFactory.getCurrentSession();
		Avatar out = (Avatar) session.get(Avatar.class, id);
		return out;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Avatar avatar) {
		Session session = sessionFactory.getCurrentSession();
		session.save(avatar);
	}
}
