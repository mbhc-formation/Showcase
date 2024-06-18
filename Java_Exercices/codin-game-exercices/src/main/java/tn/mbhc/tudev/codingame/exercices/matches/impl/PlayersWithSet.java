package tn.mbhc.tudev.codingame.exercices.matches.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import tn.mbhc.tudev.codingame.exercices.matches.IPlayers;

class PlayersWithSet implements IPlayers {
	
	private static final int LOSER_INDEX_IN_MATCH_ARRAY = 1;
	private static final int WINNER_INDEX_IN_MATCH_ARRAY = 0;
	
	private Set<Integer> winners = new TreeSet<>(Comparable::compareTo);
	private Set<Integer> playersWithOneLoss = new TreeSet<>(Comparable::compareTo);
	private Set<Integer> playersWithMoreThanOneLoss = new TreeSet<>(Comparable::compareTo);
	
	public List<List<Integer>> findWinners(int[][] matches) {
		for(int[] match : matches) {
			addToWinnersListIfNeverLost(getWinner(match));
			addLoserToLosersList(getLoser(match));
		}
		removeAnyLoserFromTheFinalWinnersList();
		return List.of(new ArrayList<>(winners), new ArrayList<>(playersWithOneLoss));
	}

	/**
	 * Returns the loser number from the given match result.
	 * @param match
	 * @return
	 */
	private int getLoser(final int[] match) {
		return match[LOSER_INDEX_IN_MATCH_ARRAY];
	}

	/**
	 * Returns the winner number from the given match result.
	 * @param match
	 * @return
	 */
	private int getWinner(final int[] match) {
		return match[WINNER_INDEX_IN_MATCH_ARRAY];
	}
	
	/**
	 * Manager losers : add loser to unique losers list if he lost one match, else remove it from unique
	 * losers list and add it to multiple losers list.
	 * 
	 * @param loserNumber
	 */
	private void addLoserToLosersList(int loserNumber) {
		if(playersWithOneLoss.contains(loserNumber)) {
			playersWithOneLoss.remove(loserNumber);
			playersWithMoreThanOneLoss.add(loserNumber);
		} else {
			if(!playersWithMoreThanOneLoss.contains(loserNumber)) {
				playersWithOneLoss.add(loserNumber);
			}
		}
	}

	/**
	 * Since a loser can be added to winners list when processing, we ensure to keep
	 * only the exclusive winners in the final list.
	 */
	private void removeAnyLoserFromTheFinalWinnersList() {
		winners.removeAll(playersWithOneLoss);
		winners.removeAll(playersWithMoreThanOneLoss);
	}
	
	private void addToWinnersListIfNeverLost(int playerNumber) {
		if(playerHasLostAtLeastOneMatch(playerNumber) && playerHasNotWonYet(playerNumber)) {
			winners.add(playerNumber);
		}
	}

	private boolean playerHasNotWonYet(final int playerNumber) {
		return !winners.contains(playerNumber);
	}
	
	private boolean playerHasLostAtLeastOneMatch(final int playerNumber) {
		return !playersWithOneLoss.contains(playerNumber) && !playersWithMoreThanOneLoss.contains(playerNumber);
	}
	
}