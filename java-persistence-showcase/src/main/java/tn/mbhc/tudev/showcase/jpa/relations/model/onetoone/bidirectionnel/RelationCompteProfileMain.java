package tn.mbhc.tudev.showcase.jpa.relations.model.onetoone.bidirectionnel;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import tn.mbhc.tudev.showcase.jpa.utils.HibernateUtil;

public class RelationCompteProfileMain {

	public static void main(String[] args) {
		
		EntityManager entityManager = HibernateUtil.createEntityManager();
		UtilisateurRepository repository = new UtilisateurRepository(entityManager);
		
		/*
		 * Création d'un compte et d'un profil utilisateur
		 */
		Compte compte = new Compte();
		compte.setUsername("test");
		compte.setPassword("test@123*!$");
		compte.setDateDeCreation(LocalDate.now());
		compte.setDateDerniereConnexion(null);
		
		Profile profile = new Profile();
		profile.setPseudo("test_pseudo");
		profile.setDescription("Ceci est le profile du user : test_pseudo");
		
		// On fait l'association entre le profile et le compte
		// Une bonne pratique est de regrouper ces deux lignes
		// dans une seule méthode dans la classe Compte par exemple
		profile.setCompte(compte);
		compte.setProfile(profile);
		
		repository.persister(compte);
		
		// On ferme l'entity manager pour nettoyer les ressources
		entityManager.close();
		HibernateUtil.shutDown();
		// On arrête l'application (à ne pas faire dans une vraie application)
		System.exit(0);
	}

}
