package tn.mbhc.tudev.codingame.exercices.temperatures;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TemperaturesMain {
	
	private static final int DEFAULT_ZERO_TEMPERATURE = 0;
	private static final Logger LOGGER = Logger.getAnonymousLogger();
	
	/**
	 * Dans cet exercice, vous devez analyser un relevé de températures pour trouver quelle température se rapproche le plus de zéro.
	 * 
	 * Exemple : 
	 * 	- Données de température :
	 * 		[7, -10, 13, 8, 4, -7, -12, -3, 3, -9, 6, -1, -6, 7]
	 * 
	 * Consignes : 
	 * 		Écrivez un programme qui affiche la température la plus proche de 0 
	 * 		parmi les données d'entrée. 
	 * 		Si deux nombres sont aussi proches de zéro, alors l'entier positif 
	 * 		sera considéré comme étant le plus proche de zéro 
	 * 		(par exemple, si les températures sont -5 et 5, alors afficher 5).
	 **/
    public static void main(String[] args) {
    	try(Scanner in = new Scanner(System.in)) {
            int n = in.nextInt(); // the number of temperatures to analyse

            if(n == DEFAULT_ZERO_TEMPERATURE) {
            	LOGGER.info("Temperature data array is empty.");
            	LOGGER.log(Level.INFO, () -> "Closest value is :" + DEFAULT_ZERO_TEMPERATURE);
                return;
            }
	        
            int[] temperatures = new int[n];
            for (int i = 0; i < n; i++) {
            	temperatures[i] = in.nextInt(); // Read the temperature
            }
            
            int closestTemp = Temperatures.closestToZero(temperatures);
            LOGGER.log(Level.FINE, "Closest temperature is : {}", String.valueOf(closestTemp));
        }
    }
    
}
