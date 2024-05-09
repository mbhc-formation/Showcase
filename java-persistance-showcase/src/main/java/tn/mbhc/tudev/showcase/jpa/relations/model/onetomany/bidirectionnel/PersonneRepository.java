package tn.mbhc.tudev.showcase.jpa.relations.model.onetomany.bidirectionnel;

import java.util.Optional;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

/**
 * Repository pour les entités {@link Personne}.
 */
public final class PersonneRepository {
	
	private static final Logger LOGGER = Logger.getLogger(PersonneRepository.class.getSimpleName());
	
	private final EntityManager entityManager;
	
	/**
	 * Crée une nouvelle instance du repository.
	 * 
	 * @param entityManager
	 */
	public PersonneRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/**
	 * Persiste l'entité {@link Personne} mais aussi les entités {@link Adresse} qui lui sont associées.
	 * 
	 * @param personne
	 * @return
	 */
	public Long persister(final Personne personne) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		
		// On a pas définit de cascade entre Personne et Adresse
		// donc on doit persister manuellement les entités et les relations 
		this.entityManager.persist(personne);

		// ensuite on persiste les relations
		personne
			.getAdresses()
			.stream()
			.forEach(adresse -> this.entityManager.persist(adresse));
		
		transaction.commit();
		return personne.getId();
	}
	
	/**
	 * Récupère une personne par son id.
	 * 
	 * @param identifiant
	 * @return
	 */
	public Optional<Personne> rechercheParId(final Long identifiant) {
		
		if(identifiant == null) {
			throw new IllegalArgumentException("Entity id must be not null");
		}
		
		Personne personne = null;
		try {
			personne = entityManager.find(Personne.class, identifiant);
		} catch(NoResultException ex) {
			LOGGER.severe(ex.getMessage());
		}
		return Optional.ofNullable(personne);
	}
	
	/**
	 * Met à jour l'objet {@link Personne} indiqué.
	 * @param personne
	 * @return
	 */
	public Personne modifier(final Personne personne) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		Personne mergedPersonne = entityManager.merge(personne);
		transaction.commit();
		return mergedPersonne;
	}
	
	/**
	 * Supprime l'objet {@link Personne} indiqué.
	 * 
	 * @param personne
	 */
	public void supprimer(final Personne personne) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(personne);
		transaction.commit();
	}
	
	/**
	 * Supprime l'objet {@link Personne} indiqué par son id.
	 * 
	 * @param personne
	 */
	public void supprimer(final Long id) {
		Optional<Personne> personneById = rechercheParId(id);
		personneById.ifPresent(personne -> {
			supprimer(personne);
		});
	}
	
}
