package dao;

import java.util.List;

import org.hibernate.Session;

import beans.Article;
import beans.Commande;
import beans.UserManagement;

public class CommandeDaoImpl implements CommandeDao {
	private final static Class CLASS = UserManagement.class;
	
	DaoFactory factory ;
	
	public CommandeDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public Commande find(Integer id) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		Commande u = (Commande) session.createQuery("from commande WHERE codeCmd = "+id,Commande.class).list();
		
		//System.out.println(session.createQuery("from User", User.class).getResultList());
		session.getTransaction().commit();
		return u;
	
	

}

	@Override
	public List<Commande> findAll() {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		List<Commande> u = session.createQuery("from commande",Commande.class).list();
		
		//System.out.println(session.createQuery("from User", User.class).getResultList());
		session.getTransaction().commit();
		return u;
	
	}

	@Override
	public boolean insert(Commande obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.update	(obj);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean delete(Commande obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		return false;
	}
}