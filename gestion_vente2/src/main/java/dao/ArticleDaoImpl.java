package dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;

import beans.Article;
import beans.Commande;
import beans.User;

public class ArticleDaoImpl implements ArticleDao {
	private final static Class CLASS = Article.class;
	DaoFactory factory ;

	public ArticleDaoImpl(DaoFactory daoFactory) {
		this.factory = factory;
	}


	@Override
	public List<Article> findAll() {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		List<Article> u = session.createQuery("from article a inner join a.artickStock").list();
		System.out.println(u);
		//System.out.println(session.createQuery("from User", User.class).getResultList());
		session.getTransaction().commit();
		return u;
	}

	@Override
	public Article find(Integer id) {
		// TODO Auto-generated method stub
			Session session = this.factory.buildSessionFactory(CLASS).openSession();
			session.beginTransaction();
			Article u = new Article();
			List<Article> obj = (List<Article>) session.createQuery("from article WHERE codeArt="+id,Article.class).list();
			System.out.println("ArticleDaoImpl.find() : " +obj.get(0).getPrixArt());
			u.setCodeArt(obj.get(0).getCodeArt());
			u.setNomArt(obj.get(0).getNomArt());
			u.setPrixArt(obj.get(0).getPrixArt());
			u.setDescArt(obj.get(0).getDescArt());
			//System.out.println(session.createQuery("from User", User.class).getResultList());
			session.getTransaction().commit();
			return u;
	}

	@Override
	public boolean insert(Article obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean update(Article obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean delete(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
