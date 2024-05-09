package tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.bidirectionnel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Compte {

	@Id
	@GeneratedValue
	private Long id;
	
	@Basic(optional = false)
	private String username;
	
	@Basic(optional = false)
	private String password;

	@Column(name = "date_de_creation")
	private LocalDate dateDeCreation;
	
	// On veut avoir la date de dernière connexion 
	// dans le programme (en mémoire) mais pas en base de données
	@Transient
	private LocalDateTime dateDerniereConnexion;
	
	@OneToOne(mappedBy = "compte", fetch = FetchType.LAZY)
	private Profile profile;
	
	public Compte() {
	}
	
	public Long getId() {
		return id;
	}
	
	public LocalDate getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(LocalDate dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	
	public LocalDateTime getDateDerniereConnexion() {
		return dateDerniereConnexion;
	}
	public void setDateDerniereConnexion(LocalDateTime dateDerniereConnexion) {
		this.dateDerniereConnexion = dateDerniereConnexion;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		// 1er sens de la relation
		this.profile = profile;
		
		// Sens inverse de la relation
		this.profile.setCompte(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", dateDeCreation=");
		builder.append(dateDeCreation);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDeCreation, id, password, profile, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(dateDeCreation, other.dateDeCreation) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(profile, other.profile)
				&& Objects.equals(username, other.username);
	}
	
	
}
