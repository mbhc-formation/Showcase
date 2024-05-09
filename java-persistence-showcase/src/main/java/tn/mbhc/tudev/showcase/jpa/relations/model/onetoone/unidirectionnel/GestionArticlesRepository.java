package tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.unidirectionnel;

import java.util.Optional;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

/**
 * Repository pour les entités {@link Article} et {@link FicheDescriptive}
 */
public final class GestionArticlesRepository {

	private static final Logger LOGGER = Logger.getLogger(GestionArticlesRepository.class.getSimpleName());
	
	private final EntityManager entityManager;
	
	/**
	 * @param entityManager
	 */
	public GestionArticlesRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/**
	 * @param article
	 * @return
	 */
	public Long persister(final Article article) {
		save(article);
		return article.getId();
	}
	
	/**
	 * @param fiche
	 * @return
	 */
	public Long persister(final FicheDescriptive fiche) {
		save(fiche);
		return fiche.getId();
	}
	
	/**
	 * @param identifiantArticle
	 * @return
	 */
	public Optional<Article> rechercheArticleParId(final Long identifiantArticle) {
		if(identifiantArticle == null) {
			throw new IllegalArgumentException("Entity id must be not null");
		}
		
		Article article = null;
		try {
			article = entityManager.find(Article.class, identifiantArticle);
		} catch(NoResultException ex) {
			LOGGER.severe(ex.getMessage());
		}
		return Optional.ofNullable(article);
	}
	
	/**
	 * @param identifiantFiche
	 * @return
	 */
	public Optional<FicheDescriptive> rechercheFicheDescriptiveParId(final Long identifiantFiche) {
		if(identifiantFiche == null) {
			throw new IllegalArgumentException("Entity id must be not null");
		}
		
		FicheDescriptive fiche = null;
		try {
			fiche = entityManager.find(FicheDescriptive.class, identifiantFiche);
		} catch(NoResultException ex) {
			LOGGER.severe(ex.getMessage());
		}
		return Optional.ofNullable(fiche);
	}
	
	/**
	 * @param article
	 * @return
	 */
	public Article modifierArticle(final Article article) {
		return merge(article);
	}
	
	/**
	 * @param fiche
	 * @return
	 */
	public FicheDescriptive modifierFicheDescriptive(final FicheDescriptive fiche) {
		return merge(fiche);
	}
	
	/**
	 * @param article
	 */
	public void supprimerArticle(final Article article) {
		remove(article);
	}
	
	/**
	 * @param fiche
	 */
	public void supprimerFicheDescriptive(final FicheDescriptive fiche) {
		remove(fiche);
	}
	
	/*
	 * Private methods
	 */
	/**
	 * Sauvegarde générique d'objets.
	 * @param <T> entité à sauvegarder
	 * @param objet
	 */
	private <T> void save(T objet) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		
		this.entityManager.persist(objet);
		this.entityManager.flush();
		
		transaction.commit();
	}
	
	/**
	 * Sauvegarde générique d'objets.
	 * @param <T> entité à sauvegarder
	 * @param objet
	 */
	private <T> T merge(T objet) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		objet = this.entityManager.merge(objet);
		transaction.commit();
		return objet;
	}
	
	/**
	 * Suppression générique d'objets. 
	 * @param <T>
	 * @param objet
	 */
	private <T> void remove(T objet) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(objet);
		transaction.commit();
	}
}
