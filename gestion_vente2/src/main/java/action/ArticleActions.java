package action;

import java.util.ArrayList;

import beans.Article;
import beans.User;
import dao.DaoFactory;

public class ArticleActions {

	private  ArrayList<Article> articles = null;	
	private Integer codeArt;
	private String nomArt;
	private String descArt ;
	private Integer prixArt ;
	private Integer qteArt;
	
	public Integer getQteArt() {
		return qteArt;
	}

	public void setQteArt(Integer qteArt) {
		this.qteArt = qteArt;
	}

	public Integer getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(Integer codeArt) {
		this.codeArt = codeArt;
	}

	public String getNomArt() {
		return nomArt;
	}

	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}

	public String getDescArt() {
		return descArt;
	}

	public void setDescArt(String descArt) {
		this.descArt = descArt;
	}

	public Integer getPrixArt() {
		return prixArt;
	}

	public void setPrixArt(Integer prixArt) {
		this.prixArt = prixArt;
	}

	public String findAll() {
		
		articles =(ArrayList<Article>) DaoFactory.getInstance().getArticleDao().findAll();
		
		return "SUCCESS";
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	
	public String addArticle() {
		
		Article u = new Article();
		try{
			
			u.setCodeArt(codeArt);
			u.setNomArt(nomArt);
			u.setDescArt(descArt);
			u.setPrixArt(prixArt);
			//u.setQteArt(qteArt);
			if(prixArt !=null && codeArt!=null && nomArt!=null && descArt!=null && qteArt != null ) {
			DaoFactory.getInstance().getArticleDao().insert(u);
			}
			return "SUCCES";
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	public String updateArticle(Integer codeArt) {
		
		Article u = new Article();
		try{
			//u.setCodeUser(2);
	
			//u.setCodeArt(codeArt);
			u.setNomArt(nomArt);
			u.setDescArt(descArt);
			u.setPrixArt(prixArt);
			//u.setQteArt(qteArt);
			
			if(prixArt !=null && codeArt!=null && nomArt!=null && descArt!=null ) {
			DaoFactory.getInstance().getArticleDao().update(u);
			}
			return "SUCCES";
		}catch(Exception e) {
			return "ERROR";
		}
	}
		
}
