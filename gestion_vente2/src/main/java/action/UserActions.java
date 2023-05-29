package action;

import java.util.ArrayList;

import javax.management.Query;

import beans.User;
import beans.UserManagement;
import dao.DaoFactory;

public class UserActions {

	private ArrayList<User> users = null;
	
	private Integer codeUser;
	private String login ;
	private String pass ;
	public String message;
	public Integer getCodeUser() {
		return codeUser;
	}
	public void setCodeUser(Integer codeUser) {
		this.codeUser = codeUser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	private User user;

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String register() {
		
		 User u = new User();
		try{
			//u.setCodeUser(2);
			u.setLogin(login);
			u.setPass(pass);
			DaoFactory.getInstance().getUserDao().insert(u);
			
			return "LOGGEDIN";
		}catch(Exception e) {
			message = "err";
			return "FIELDLOG";
		}
	}
	
	
	public String login() {
		
		// User u = new User();
		try{
			//u.setCodeUser(2);
			//u.setLogin(login);
			//u.setPass(pass);
			//DaoFactory.getInstance().getUserDao().insert(u);
			//System.out.println("it oky");
		
			boolean auth = DaoFactory.getInstance().getUserDao().findlogin(login , pass);
			if(auth) {
				return "LOGGEDIN";
			}else {
				return "FIELDLOG";
			}
			
			
		}catch(Exception e) {
			return "FIELDLOG";
		}
	}
	public String UserList() {
		users =(ArrayList<User>) DaoFactory.getInstance().getUserDao().findAll();
		return "SUCCESS";
	}
	public String delete() {
		User u = new User();
		u.setPass("iiii");
		u.setLogin("hhhhhhhhh");
		u.setCodeUser(2);
	  DaoFactory.getInstance().getUserDao().delete(u);
		return "SUCCESS";
	}
	
	
public String addUsers() {
		
		User u = new User();
		try{
			//u.setCodeUser(2);
			u.setLogin(login);
			u.setPass(pass);
			DaoFactory.getInstance().getUserDao().insert(u);
			return "SUCCES";
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
		public String savePassword() {
		
			User u = new User();
		try{
			u.setCodeUser(codeUser);
			u.setLogin(login);
			u.setPass(pass);
			DaoFactory.getInstance().getUserDao().update(u);
			
			return "SUCCES";
		}catch(Exception e) {
			return "ERROR";
		}
	}
		
		public String deleteObject() {
			
			User u = new User();
		try{
			u.setCodeUser(codeUser);
			u.setLogin(login);
			System.out.println("Code user :" + codeUser);
			u.setPass(pass);
			DaoFactory.getInstance().getUserDao().delete(u);
			
			return "SUCCES";
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	
	
}
