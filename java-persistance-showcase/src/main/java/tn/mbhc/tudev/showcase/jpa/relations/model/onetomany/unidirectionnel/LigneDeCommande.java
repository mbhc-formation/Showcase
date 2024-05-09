package tn.mbhc.tudev.showcase.jpa.relations.model.onetomany.unidirectionnel;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_de_commande")
public class LigneDeCommande {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "total_ligne")
	private BigDecimal totalLigne;

	private Integer quantite;

	@Basic
	private String details;

	public Long getId() {
		return id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getTotalLigne() {
		return totalLigne;
	}

	public void setTotalLigne(BigDecimal totalLigne) {
		this.totalLigne = totalLigne;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LigneDeCommande [id=");
		builder.append(id);
		builder.append(", totalLigne=");
		builder.append(totalLigne);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append(", details=");
		builder.append(details);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(details, id, quantite, totalLigne);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneDeCommande other = (LigneDeCommande) obj;
		return Objects.equals(details, other.details) && Objects.equals(id, other.id)
				&& Objects.equals(quantite, other.quantite) && Objects.equals(totalLigne, other.totalLigne);
	}
	
}
