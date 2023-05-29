package dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import beans.User;

public class UserDaoImpl implements UserDao {

	private final static Class CLASS = User.class;
	
	DaoFactory factory ;
	
	public UserDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<User> findAll() {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		List<User> u = session.createQuery("from User",User.class).list();
		
		//System.out.println(session.createQuery("from User", User.class).getResultList());
		session.getTransaction().commit();
		return u;
	}

	@Override
	public User find(Integer id) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		List<User> u = session.createQuery("from User WHERE codeUser="+id,User.class).list();
		System.out.print(u.get(0).getLogin());
		session.getTransaction().commit();
		return null;
	}
	
	
	
	
	@Override
	public boolean findlogin(String login, String pass) {
		try {
			Session session = this.factory.buildSessionFactory(CLASS).openSession();
			session.beginTransaction();
		//	System.out.print(pass +"   "+ login);
			Integer u =  session.createQuery("from User WHERE login="+"'"+login+"'"+" and pass="+"'"+pass+"'",User.class).list().get(0).getCodeUser();
			//System.out.print("id : "+u);
			session.getTransaction().commit();
			return  true;
		}catch(Exception e) {
			//System.out.print("id : fase ");
			return  false;
		}
		
	}

	@Override
	public boolean insert(User obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		return true;
	}
	
	

	@Override
	public boolean update(User obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		return false;
	}

}
