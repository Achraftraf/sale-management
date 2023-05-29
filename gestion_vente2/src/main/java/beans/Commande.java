package beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "commande")

@Table(name = "commande")

public class Commande {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "codeCmd", unique = true, nullable = false)
	private Integer codeCmd;
	@Column(name = "client")
	private String client;
	@Column(name = "codeArt")
	private Integer codeArt;
	@Column(name = "qteCmd")
	private Integer qteCmd;
	@Column(name = "dateCmd")
	private String dateCmd;
	public Integer getCodeCmd() {
		return codeCmd;
	}
	public void setCodeCmd(Integer codeCmd) {
		this.codeCmd = codeCmd;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Integer getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(Integer codeArt) {
		this.codeArt = codeArt;
	}
	public Integer getQteCmd() {
		return qteCmd;
	}
	public void setQteCmd(Integer qteCmd) {
		this.qteCmd = qteCmd;
	}
	public String getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(String dateCmd) {
		this.dateCmd = dateCmd;
	}
	@Override
	public String toString() {
		return "Commande [codeCmd=" + codeCmd + ", client=" + client + ", codeArt=" + codeArt + ", qteCmd=" + qteCmd
				+ ", dateCmd=" + dateCmd + "]";
	}
	

	
	
	
}
