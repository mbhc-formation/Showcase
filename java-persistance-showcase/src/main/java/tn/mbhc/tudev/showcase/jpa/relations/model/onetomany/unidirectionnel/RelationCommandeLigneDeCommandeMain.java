package tn.mbhc.tudev.showcase.jpa.relations.model.onetomany.unidirectionnel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import javax.persistence.EntityManager;

import tn.mbhc.tudev.showcase.jpa.utils.HibernateUtil;

public class RelationCommandeLigneDeCommandeMain {

	public static void main(String[] args) {
		
		EntityManager entityManager = HibernateUtil.createEntityManager();
		CommandeRepository repository = new CommandeRepository(entityManager);
		
		/*
		 * Création d'une commande avec plusieurs lignes
		 */
		LigneDeCommande first = new LigneDeCommande();
		first.setDetails("Première ligne");
		first.setQuantite(10);
		first.setTotalLigne(new BigDecimal(25.20).setScale(2, RoundingMode.CEILING));
		
		LigneDeCommande second = new LigneDeCommande();
		second.setDetails("Deuxième ligne");
		second.setQuantite(5);
		second.setTotalLigne(new BigDecimal(35.00).setScale(2, RoundingMode.CEILING));
		
		Commande commande = new Commande();
		commande.ajouterLigneCommande(first);
		commande.ajouterLigneCommande(second);
		
		System.out.println("***** Sauvegarde de commande *****");
		Long idCommande = repository.persister(commande);
		System.out.println("---- Commande créée : " + commande);
		
		System.out.println();
		
		// Recherche de la commande par id
		System.out.println("***** Recherche de commande *****");
		Optional<Commande> optional = repository.rechercheParId(idCommande);
		if(optional.isPresent()) {
			commande = optional.get();
			System.out.println(String.format("-- Commande trouvée par l'id : %d", commande.getId()));
			System.out.println("-- Détail de la commande : ");
			commande.afficherLesLignesDeCommande();
			
			System.out.println("-- Total commande : ");
			System.out.println(String.format("%.2f €", commande.calculerTotalCommande()));
		}
		
		System.out.println("***** Modification d'une ligne de commande *****");
		
		first.setDetails("Première ligne modifée");
		first.setQuantite(20);
		first.setTotalLigne(new BigDecimal(27.25).setScale(2, RoundingMode.CEILING));
		
		second.setDetails("Deuxième ligne modifée");
		second.setQuantite(30);
		second.setTotalLigne(new BigDecimal(35.15).setScale(2, RoundingMode.CEILING));
		
		// Mise à jour de l'objet commande (en mémoire)
		commande.modifierLigneDeCommande(first);
		commande.modifierLigneDeCommande(second);
		
		// Mise à jour de l'objet commande (en bdd)
		repository.modifier(commande);

		System.out.println("-- Détail de la commande après modification : ");
		commande.afficherLesLignesDeCommande();
		
		System.out.println("-- Total commande : ");
		System.out.println(String.format("%.2f €", commande.calculerTotalCommande()));
		
		// Nettoyer les ressources
		entityManager.close();
		HibernateUtil.shutDown();
		
		// On arrête l'application (à ne pas faire dans une vraie application)
		System.exit(0);
	}

}
