package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import beans.*;

public class DaoFactory {

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;
	
	
	
	public static SessionFactory buildSessionFactory(Class c) {
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg-Vente.xml");
		configObj.addAnnotatedClass(UserManagement.class);
		configObj.addAnnotatedClass(User.class);
		configObj.addAnnotatedClass(Article.class);
		configObj.addAnnotatedClass(ArticleStock.class);
		configObj.addAnnotatedClass(Commande.class);
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static DaoFactory getInstance() {
		return new DaoFactory();
	}
	
	public UserDao getUserDao() {
		return new UserDaoImpl(this);
	}
	public UserManagementDao getUserManagementDao() {
		return new UserManagementDaoImpl(this);
	}
	public ArticleDao getArticleDao() {
		return new ArticleDaoImpl(this);
	}
	public CommandeDao getCommandeDao() {
		return new CommandeDaoImpl(this);
	}
	public ArticleStockDao getArticleStorDao() {
		return new ArticleStockDaoImpl(this);
	}


	
	
}
