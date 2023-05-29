package action;

import java.util.ArrayList;

import javax.management.Query;

import beans.User;
import beans.UserManagement;
import dao.DaoFactory;

public class UserManagementActions {

	private ArrayList<UserManagement> users = null;
	
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
	
	private UserManagement user;

	public ArrayList<UserManagement> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UserManagement> users) {
		this.users = users;
	}

	
	public String addUsers() {
		
		UserManagement u = new UserManagement();
		try{
			//u.setCodeUser(2);
			u.setLogin(login);
			u.setPass(pass);
			DaoFactory.getInstance().getUserManagementDao().insert(u);
			
			return "SUCCES";
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
		public String savePassword() {
		
		UserManagement u = new UserManagement();
		try{
			u.setCodeUser(codeUser);
			u.setLogin(login);
			u.setPass(pass);
			DaoFactory.getInstance().getUserManagementDao().update(u);
			
			return "SUCCES";
		}catch(Exception e) {
			return "ERROR";
		}
	}
		
		public String deleteObject() {
			
		UserManagement u = new UserManagement();
		try{
			u.setCodeUser(codeUser);
			u.setLogin(login);
			u.setPass(pass);
			DaoFactory.getInstance().getUserManagementDao().delete(u);
			
			return "SUCCES";
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	
	public String UserList() {
		users =(ArrayList<UserManagement>) DaoFactory.getInstance().getUserManagementDao().findAll();
		return "SUCCESS";
	}
	
	
	
	
	
}
