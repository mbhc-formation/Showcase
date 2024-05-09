package tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.unidirectionnel;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.unidirectionnel.Article.Categorie;

@Entity
public class FicheDescriptive {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "desc_courte")
	private String descriptionCourte;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "desc_longue")
	private String descriptionLongue;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "cover")
	private Byte[] photoCouverture;

	@Enumerated(EnumType.STRING)
	private Categorie categorie;

	@OneToOne
	@JoinColumn(name = "fk_article", unique = true)
	private Article article;

	public Long getId() {
		return id;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getDescriptionCourte() {
		return descriptionCourte;
	}

	public void setDescriptionCourte(String descriptionCourte) {
		this.descriptionCourte = descriptionCourte;
	}

	public String getDescriptionLongue() {
		return descriptionLongue;
	}

	public void setDescriptionLongue(String descriptionLongue) {
		this.descriptionLongue = descriptionLongue;
	}

	public Byte[] getPhotoCouverture() {
		return photoCouverture;
	}

	public void setPhotoCouverture(Byte[] photoCouverture) {
		this.photoCouverture = photoCouverture;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FicheDescriptive [id=");
		builder.append(id);
		builder.append(", descriptionCourte=");
		builder.append(descriptionCourte);
		builder.append(", descriptionLongue=");
		builder.append(descriptionLongue);
		builder.append(", photoCouverture=");
		builder.append(Arrays.toString(photoCouverture));
		builder.append(", categorie=");
		builder.append(categorie);
		builder.append(", article=");
		builder.append(article);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(article, categorie, id);
	}

	/*
	 * L'égalité des fiches descriptives est faite sur l'id, l'article concerné et
	 * la catégorie
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FicheDescriptive other = (FicheDescriptive) obj;
		return Objects.equals(article, other.article) && categorie == other.categorie && Objects.equals(id, other.id);
	}

}
