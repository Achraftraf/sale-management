package dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import beans.UserManagement;

public class UserManagementDaoImpl implements UserManagementDao {

	private final static Class CLASS = UserManagement.class;
	
	DaoFactory factory ;
	
	public UserManagementDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<UserManagement> findAll() {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		List<UserManagement> u = session.createQuery("from Users",UserManagement.class).list();
		
		//System.out.println(session.createQuery("from User", User.class).getResultList());
		session.getTransaction().commit();
		return u;
	}

	@Override
	public UserManagement find(Integer id) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		List<UserManagement> u = session.createQuery("from Users WHERE codeUser="+id,UserManagement.class).list();
		System.out.print(u.get(0).getLogin());
		session.getTransaction().commit();
		return null;
	}
	
	

	@Override
	public boolean insert(UserManagement obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		return true;
	}
	
	

	@Override
	public boolean update(UserManagement obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.update	(obj);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean delete(UserManagement obj) {
		// TODO Auto-generated method stub
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		return false;
	}

}
