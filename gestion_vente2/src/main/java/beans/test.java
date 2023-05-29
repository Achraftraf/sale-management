package beans;

import dao.DaoFactory;

public class test {

	public static void main(String[] args) {
		ArticleStock A =  DaoFactory.getInstance().getArticleStorDao().find(2);
		System.out.print(A);

	}

}
