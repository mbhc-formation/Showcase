package tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.unidirectionnel;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

	public enum Categorie {
		// @formatter:off
		JEUX, 
		LIVRES, 
		MUSIQUE
		// @formatter:on
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Basic(optional = false)
	private String libelle;
	
	@Column(name = "en_stock")
	private Boolean enStock;
	
	private BigDecimal prix;
	
	public Long getId() {
		return id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Boolean isEnStock() {
		return enStock;
	}
	public void setEnStock(Boolean enStock) {
		this.enStock = enStock;
	}
	
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", enStock=");
		builder.append(enStock);
		builder.append(", prix=");
		builder.append(prix);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, libelle);
	}

	/*
	 * L'égalité de deux articles est faite sur l'id et le libellé
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(id, other.id) && Objects.equals(libelle, other.libelle);
	}
	
	
}
