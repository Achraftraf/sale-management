package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "article_stock")
@Table(name = "article_stock")
public class ArticleStock {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "codeArt", unique = true, nullable = false)
	private Integer codeArt;
	@Column(name = "nomArt")
	private String nomArt;
	@Column(name = "descArt")
	private String descArt ;
	@Column(name = "prixArt")
	private Integer prixArt ;
	@Column(name = "qteArt")
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
	


}