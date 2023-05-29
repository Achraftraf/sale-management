package dao;

import beans.User;

public interface UserDao extends DAO<User>{

	boolean findlogin(String login, String pass);

}
