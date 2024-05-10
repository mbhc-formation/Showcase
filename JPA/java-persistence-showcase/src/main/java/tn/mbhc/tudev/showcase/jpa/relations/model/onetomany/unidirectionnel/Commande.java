package tn.mbhc.tudev.showcase.jpa.relations.model.onetomany.unidirectionnel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Commande {

	public enum StatutCommande {
		CREATED, VALIDATED, REJECTED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "date_de_creation")
	private LocalDate dateDeCreation;

	@Enumerated(EnumType.STRING)
	private StatutCommande statut;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "commande_id")
	private List<LigneDeCommande> lignesDeCommandes;

	/**
	 * Crée une commande avec la date du jour et le statut "created" et une liste
	 * vide de lignes de commande.
	 */
	public Commande() {
		this.lignesDeCommandes = new ArrayList<>();
		this.dateDeCreation = LocalDate.now();
		this.statut = StatutCommande.CREATED;
	}
	
	/**
	 * Affiche les lignes de cette commande.
	 */
	public void afficherLesLignesDeCommande() {
		lignesDeCommandes.forEach(System.out::println);
	}
	
	/**
	 * Ajoute la ligne à la commande.
	 * @param ligneCommande
	 * @return
	 */
	public boolean ajouterLigneCommande(final LigneDeCommande ligneCommande) {
		if(lignesDeCommandes.contains(ligneCommande)) 
			return false;
		
		return this.lignesDeCommandes.add(ligneCommande);
	}

	/**
	 * Calcule le total de la commande.
	 * @return
	 */
	public BigDecimal calculerTotalCommande() {
		BigDecimal sum = this.lignesDeCommandes
				.stream()
				.map(ldc -> ldc.getTotalLigne())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return sum.setScale(2, RoundingMode.CEILING);
	}
	
	/**
	 * Met à jour la ligne de commande donnée.
	 * @param ligneDeCommande
	 * @return
	 */
	public void modifierLigneDeCommande(final LigneDeCommande ligneDeCommande) {
		Optional<LigneDeCommande> byId = findById(ligneDeCommande.getId());
		if(byId.isPresent()) {
			int oldObjectIndex = lignesDeCommandes.indexOf(byId.get());
			lignesDeCommandes.set(oldObjectIndex, ligneDeCommande);
		}
	}
	
	/**
	 * Supprime la ligne de commande donnée.
	 * @param ligneDeCommande
	 * @return
	 */
	public boolean supprimerLigneDeCommande(final LigneDeCommande ligneDeCommande) {
		if(ligneDeCommande == null)
			throw new IllegalArgumentException("Object to remove must not be null");
		
		if(findById(ligneDeCommande.getId()).isEmpty())
			return false;
		
		return removeById(ligneDeCommande.getId());
	}
	
	/**
	 * Recherche de ligne de commande par id.
	 * @param idLigne
	 * @return
	 */
	private Optional<LigneDeCommande> findById(final Long idLigne) {
		if(idLigne == null)
			throw new IllegalArgumentException("Id must not be null");
		
		return lignesDeCommandes
				.parallelStream()
				.filter(ldc -> idLigne.equals(ldc.getId()))
				.findFirst();
	}
	
	/**
	 * Recherche de ligne de commande par id.
	 * @param idLigne
	 * @return 
	 * @throws IllegalArgumentException
	 */
	private boolean removeById(final Long idLigne) throws IllegalArgumentException {
		if(idLigne == null)
			throw new IllegalArgumentException("Id must not be null");
		
		boolean removed = false;
		Iterator<LigneDeCommande> iterator = lignesDeCommandes.iterator();
		while(iterator.hasNext()) {
			LigneDeCommande ligneDeCommande = iterator.next();
			if(ligneDeCommande.getId().equals(id)) {
				iterator.remove();
				removed = true;
			}
		}
		return removed;
	}
	
	/*
	 * Acceseurs 
	 */
	public Long getId() {
		return id;
	}

	public LocalDate getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(LocalDate dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	
	public StatutCommande getStatut() {
		return statut;
	}

	public void setStatut(StatutCommande statut) {
		this.statut = statut;
	}

	public List<LigneDeCommande> getLignesDeCommandes() {
		return Collections.unmodifiableList(lignesDeCommandes);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Commande [id=");
		builder.append(id);
		builder.append(", dateDeCreation=");
		builder.append(dateDeCreation);
		builder.append(", statut=");
		builder.append(statut);
		builder.append(", nombreLignes=");
		builder.append(lignesDeCommandes.size());
		builder.append("]");
		return builder.toString();
	}
	
}
