package dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;

import beans.Article;
import beans.ArticleStock;
import beans.Commande;
import beans.User;

public class ArticleStockDaoImpl implements ArticleStockDao {
	private final static Class CLASS = ArticleStock.class;
	DaoFactory factory ;

	public ArticleStockDaoImpl(DaoFactory daoFactory) {
		this.factory = factory;
	}


	@Override
	public List<ArticleStock> findAll() {
		
		return null;
	}

	@Override
	public ArticleStock find(Integer id) {
		System.out.println(id);
		// TODO Auto-generated method stub
			Session session = this.factory.buildSessionFactory(CLASS).openSession();
			session.beginTransaction();
			ArticleStock u = new ArticleStock();
			List<ArticleStock> obj = session.createQuery("from article_stock WHERE codeArt="+id,ArticleStock.class).list();
			System.out.println("ArticleDaoImpl.find() : " +obj.get(0).getPrixArt());
			u.setCodeArt(obj.get(0).getCodeArt());
			u.setNomArt(obj.get(0).getNomArt());
			u.setPrixArt(obj.get(0).getPrixArt());
			u.setDescArt(obj.get(0).getDescArt());
			u.setQteArt(obj.get(0).getQteArt());
			//System.out.println(session.createQuery("from User", User.class).getResultList());
			session.getTransaction().commit();
			return u;
	}

	@Override
	public boolean insert(ArticleStock obj) {
		
		return false;
	}

	@Override
	public boolean update(ArticleStock obj) {
		Session session = this.factory.buildSessionFactory(CLASS).openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean delete(ArticleStock obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
