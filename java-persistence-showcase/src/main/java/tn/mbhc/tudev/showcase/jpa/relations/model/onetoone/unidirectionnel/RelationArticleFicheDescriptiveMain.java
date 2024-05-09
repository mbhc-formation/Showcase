package tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.unidirectionnel;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.unidirectionnel.Article.Categorie;
import tn.mbhc.tudev.showcase.jpa.utils.HibernateUtil;

public class RelationArticleFicheDescriptiveMain {

	public static void main(String[] args) {
		
		EntityManager entityManager = HibernateUtil.createEntityManager();
		GestionArticlesRepository repository = new GestionArticlesRepository(entityManager);
		
		/*
		 * Articles
		 */
		FicheDescriptive ficheProduit = new FicheDescriptive();
		ficheProduit.setCategorie(Categorie.JEUX);
		ficheProduit.setDescriptionCourte("Jeux de courses de voitures en monde ouvert");
		ficheProduit.setDescriptionLongue("Ici il faut mettre une description longue de plus de 255 caractères");
		
		Article article = new Article();
		article.setLibelle("Forza Horizon 5");
		article.setPrix(new BigDecimal(59.00));
		article.setEnStock(true);
		
		// On fait l'association entre l'article et sa fiche
		ficheProduit.setArticle(article);
		
		// On persiste les deux entités en commençant par 
		// le côté faible de la relation : Article
		Long idArticle = repository.persister(article);
		
		// Ensuite on persiste le côté fort : la fiche
		// c'est la fiche qui porte la relation
		Long idFiche = repository.persister(ficheProduit);
		
		System.out.println("Article persisté avec id : " + idArticle);
		System.out.println("FicheDescriptive persistée avec id : " + idFiche);
		
		// On ferme l'entity manager pour nettoyer les ressources
		entityManager.close();
		HibernateUtil.shutDown();
		// On arrête l'application (à ne pas faire dans une vraie application)
		System.exit(0);
	}

}
