package tn.mbhc.tudev.codingame.exercices.matches.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MatchesTestFilesHelper {
	
	private MatchesTestFilesHelper() {
		// Empty constructor
	}
	
	/**
	 * FOR TESTS ONLY. THIS IS NOT OPTIMIZED !!!
	 * @param fichier
	 * @return
	 */
	public static List<List<Integer>> lireFichierResultats(String fichier) {
		List<List<Integer>> liste = new ArrayList<>();
        
        // Lire le fichier
        String ligne;
        
		try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
			ligne = reader.readLine();
			// Retirer les crochets extérieurs
			ligne = ligne.substring(1, ligne.length() - 1);
			
			String premierTableau = ligne.substring(1, ligne.indexOf("]"));
			String secondTableau = ligne.substring(ligne.indexOf("]") + 4, ligne.length() - 1);
			
			String[] winners = premierTableau.split(",");
			List<Integer> winnersList = new ArrayList<>();
			for(String v : winners) {
				winnersList.add(Integer.parseInt(v.trim()));
			}
			liste.add(winnersList);
			
			String[] losers = secondTableau.split(",");
			List<Integer> losersList = new ArrayList<>();
			for(String v : losers) {
				losersList.add(Integer.parseInt(v.trim()));
			}
			liste.add(losersList);
			
			return liste;
		} catch (IOException e) {
			return Collections.emptyList();
		}
	}
	
	/**
	 * FOR TESTS ONLY. THIS IS NOT OPTIMIZED !!!
	 * @param fichier
	 * @return
	 */
	public static int[][] lireFichierEtCreerTableau(String fichier) throws IOException {
        List<int[]> liste = new ArrayList<>();
        int[][] resultat = null;
        
        // Lire le fichier
        try(BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
	        String ligne = reader.readLine();
	        
	        // Retirer les crochets extérieurs
	        ligne = ligne.substring(1, ligne.length() - 1);
	        
	        // Séparer les différentes paires
	        String[] paires = ligne.split("\\],\\[");
	
	        for (String paire : paires) {
	            // Retirer les crochets internes et les espaces
	            paire = paire.replace("[", "").replace("]", "").trim();
	            // Séparer les deux entiers et les ajouter au tableau
	            String[] valeurs = paire.split(",");
	            int[] tableau = new int[2];
	            tableau[0] = Integer.parseInt(valeurs[0].trim());
	            tableau[1] = Integer.parseInt(valeurs[1].trim());
	            liste.add(tableau);
	        }
	        
	        // Convertir la liste en un tableau 2D
	        resultat = new int[liste.size()][2];
	        for (int i = 0; i < liste.size(); i++) {
	            resultat[i] = liste.get(i);
	        }
        }
        return resultat;
    }
	
}
