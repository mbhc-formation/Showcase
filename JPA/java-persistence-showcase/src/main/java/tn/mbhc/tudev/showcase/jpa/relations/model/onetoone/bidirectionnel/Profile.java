package tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.bidirectionnel;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Profile {

	@Id
	@GeneratedValue
	private Long id;

	@Basic(optional = false)
	private String pseudo;

	@Column(length = 500)
	private String description;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private Byte[] photo;

	@OneToOne
	@JoinColumn(name = "compte_utilisateur_id")
	private Compte compte;
	
	public Profile() {
	}

	public Profile(String pseudo) {
		this.pseudo = pseudo;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}

	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profile [id=");
		builder.append(id);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(photo);
		result = prime * result + Objects.hash(compte, description, id, pseudo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(compte, other.compte) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Arrays.equals(photo, other.photo)
				&& Objects.equals(pseudo, other.pseudo);
	}
	
	
}
