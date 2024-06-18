package tn.mbhc.tudev.codingame.exercices.matches;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import tn.mbhc.tudev.codingame.exercices.matches.helper.MatchesTestFilesHelper;
import tn.mbhc.tudev.codingame.exercices.matches.impl.PlayersImplFactory;
import tn.mbhc.tudev.codingame.exercices.matches.impl.PlayersImplFactory.ImplmentationUsing;

public class PlayersMain {
	
	private static final Logger LOGGER = Logger.getLogger(PlayersMain.class.getSimpleName());
	
	private static final IPlayers playersImpl = PlayersImplFactory.create(ImplmentationUsing.MAP);
	
	public static void main(String[] args) throws IOException {
		
		try(Scanner scanner = new Scanner(System.in)) {
			
			LOGGER.info("Type any value to start analyzing matches, q to quit");

			String input = "";
			while(!input.equals("q")) {
				input = scanner.next();
				
				if(input.equals("q")) {
					LOGGER.info("Exiting ...");
					break;
				}
				
				String file = PlayersMain.class.getClassLoader().getResource("matches_test_files/large_matches_collection_test_matches.txt").getFile();
				int[][] matches = MatchesTestFilesHelper.lireFichierEtCreerTableau(file);
				
				List<List<Integer>> result = playersImpl.findWinners(matches);
				LOGGER.info("Result is : ");
				LOGGER.log(Level.INFO, () -> "Winners : " + result.get(0));
				LOGGER.log(Level.INFO, () -> "Players with one loss : " + result.get(1));
			}
		}
	}
}