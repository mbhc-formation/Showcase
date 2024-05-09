package tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.bidirectionnel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public final class UtilisateurRepository {

	private final EntityManager entityManager;

	public UtilisateurRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/**
	 * @param compte
	 * @return
	 */
	public Long persister(final Compte compte) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		
		// On fait la persistance des deux ici pour éviter les oublis et les incohérences
		// Me permet de m'assurer de l'ordre
		this.entityManager.persist(compte.getProfile());
		this.entityManager.persist(compte);
		this.entityManager.flush();

		transaction.commit();
		return compte.getId();
	}
	
}
