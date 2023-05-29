package beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;




@Entity(name="Users")
@Table(name="Users")

public class UserManagement {
		@Id
		@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
		@Column(name = "codeUser", unique = true, nullable = false)
		private Integer codeUser;
		
		
		@Column(name = "login", unique = true, nullable = false)
		private String login ;
		
		@Column(name = "pass")
		private String pass ;
				
		
		
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
		
		
	}


