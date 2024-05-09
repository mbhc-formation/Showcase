package tn.mbhc.tudev.showcase.jpa.relations.model.onetomany.unidirectionnel;

import java.util.Optional;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

/**
 * Repository pour les entités {@link Commande}
 */
public final class CommandeRepository {

	private static final Logger LOGGER = Logger.getLogger(CommandeRepository.class.getSimpleName());
	
	private final EntityManager entityManager;

	/**
	 * Crée une nouvelle instance du repository.
	 * 
	 * @param entityManager
	 */
	public CommandeRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Persiste l'objet {@link Commande} et ses relations marquées par une cascade ({@link LigneDeCommande})
	 * @param commande
	 * @return
	 */
	public Long persister(final Commande commande) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		
		// On a utilisé une cascade entre commande et ligne de commande
		this.entityManager.persist(commande);
		
		this.entityManager.flush();
		transaction.commit();
		
		return commande.getId();
	}

	/**
	 * @param identifiantCommande
	 * @return
	 */
	public Optional<Commande> rechercheParId(final Long identifiantCommande) {
		if(identifiantCommande == null) {
			throw new IllegalArgumentException("Entity id must be not null");
		}
		
		Commande commande = null;
		try {
			commande = this.entityManager.find(Commande.class, identifiantCommande);
		} catch(NoResultException ex) {
			LOGGER.severe(ex.getMessage());
		}
		return Optional.ofNullable(commande);
	}

	/**
	 * Met à jour l'objet {@link Commande} indiqué.
	 * @param commande
	 * @return
	 */
	public Commande modifier(final Commande commande) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		Commande merged = entityManager.merge(commande);
		transaction.commit();
		return merged;
	}
	
	/**
	 * Supprime la commande indiquée.
	 * @param commande
	 */
	public void supprimer(final Commande commande) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		this.entityManager.remove(commande);
		this.entityManager.flush();
		transaction.commit();
	}

	/**
	 * Supprime la commande indiquée par son id.
	 * @param commande
	 */
	public void supprimer(final Long identifiantCommande) {
		Optional<Commande> commandeById = rechercheParId(identifiantCommande);
		commandeById.ifPresent(cmd -> {
			supprimer(cmd);
		});
	}
}
