package tn.mbhc.tudev.showcase.jpa.relations.model.onetomany.bidirectionnel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Personne {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 100)
	private String nom;

	@Column(length = 100)
	private String prenom;

	private LocalDate dateNaissance;

	@OneToMany(mappedBy = "personne")
	private List<Adresse> adresses = new ArrayList<>();
	
	/**
	 * Dans cette méthode, pon effectue l'association bi-directionnelle pour éviter
	 * de le faire ailleurs dans le code (bonne pratique) 
	 * <br>
	 * - Personne -> Adresse 
	 * <br>
	 * - Adresse -> Personne
	 * 
	 * @param adresse
	 */
	public void affecterNouvelleAdresse(final Adresse adresse) {
		// On doit faire la relation bi-directionnelle dans les deux sens
		// 1 Sens : Adresse -> Personne
		adresse.setPersonne(this);
		// 2 Sens : Personne -> Adresse
		this.adresses.add(adresse);
	}
	
	/**
	 * Affiche les adresses de cette personne.
	 */
	public void afficherLesAdresses() {
		adresses.forEach(System.out::println);
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Adresse> getAdresses() {
		return Collections.unmodifiableList(adresses);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", adresse=");
		builder.append(adresses);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateNaissance, id, nom, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		return Objects.equals(dateNaissance, other.dateNaissance) && Objects.equals(id, other.id)
				&& Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}
	
}
