package tn.mbhc.tudev.showcase.jpa.relations.model.onetomany.bidirectionnel;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityManager;

import tn.mbhc.tudev.showcase.jpa.utils.HibernateUtil;

public class RelationPersonneAdresseMain {

	public static void main(String[] args) {
		
		EntityManager entityManager = HibernateUtil.createEntityManager();
		PersonneRepository personneRepository = new PersonneRepository(entityManager);
		
		Adresse premiereAdresse = new Adresse();
		premiereAdresse.setRue("1 rue de la Gare");
		premiereAdresse.setComplement("Résidence Bat 4, Appt 3");
		premiereAdresse.setVille("Paris");
		premiereAdresse.setCodePostal("75016");
		
		Adresse deuxiemeAdresse = new Adresse();
		deuxiemeAdresse.setRue("2 rue de la Place");
		deuxiemeAdresse.setComplement("Résidence Bat 1, Appt 1");
		deuxiemeAdresse.setVille("Lyon");
		deuxiemeAdresse.setCodePostal("69016");

		Personne personne = new Personne();
		personne.setNom("BH");
		personne.setPrenom("Mohamed");
		personne.setDateNaissance(LocalDate.of(1990, 1, 1));
		
		personne.affecterNouvelleAdresse(premiereAdresse);
		personne.affecterNouvelleAdresse(deuxiemeAdresse);

		System.out.println("***** Sauvegarde de personne *****");
		Long idPersonne = personneRepository.persister(personne);
		System.out.println(String.format("---- Nouvelle personne ajoutée avec id : %d", idPersonne));
		
		System.out.println();
		
		// Recherche de la personne par id
		System.out.println("***** Recherche de personne *****");
		Optional<Personne> optional = personneRepository.rechercheParId(idPersonne);
		if(optional.isPresent()) {
			personne = optional.get();
			System.out.println(String.format("-- Personne trouvée par l'id : %d", personne.getId()));
			System.out.println("-- Adresse(s) : ");
			personne.afficherLesAdresses();
		}
		
		// Nettoyer les ressources
		entityManager.close();
		HibernateUtil.shutDown();
		
		// Quitter
		System.exit(0);
	}

}
