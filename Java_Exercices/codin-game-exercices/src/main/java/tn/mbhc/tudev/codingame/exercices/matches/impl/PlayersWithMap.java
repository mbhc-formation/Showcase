package tn.mbhc.tudev.codingame.exercices.matches.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import tn.mbhc.tudev.codingame.exercices.matches.IPlayers;

class PlayersWithMap implements IPlayers {
	
	private static final int LOSER_INDEX_IN_MATCH_ARRAY = 1;
	private static final int WINNER_INDEX_IN_MATCH_ARRAY = 0;
	
	private static final int EXACTLY_ONE_LOSS = 1;
	private static final int NO_LOSSES = 0;
	
	private Map<Integer, Integer> lossCount = new HashMap<>();
	
	@Override
	public List<List<Integer>> findWinners(int[][] matches) {
		for (int[] match : matches) {
			
			int winner = match[WINNER_INDEX_IN_MATCH_ARRAY];
			int loser = match[LOSER_INDEX_IN_MATCH_ARRAY];
			
			lossCount.putIfAbsent(winner, NO_LOSSES);
			lossCount.put(loser, lossCount.getOrDefault(loser, NO_LOSSES) + 1);
		}

		Set<Integer> noLossPlayers = new TreeSet<>(Comparable::compareTo);
		Set<Integer> oneLossPlayers = new TreeSet<>(Comparable::compareTo);
		
		lossCount
			.entrySet()
			.parallelStream()
			.forEachOrdered(entry -> {
				if (entry.getValue() == NO_LOSSES) {
					noLossPlayers.add(entry.getKey());
				} else if (entry.getValue() == EXACTLY_ONE_LOSS) {
					oneLossPlayers.add(entry.getKey());
				}
			});
		return List.of(new ArrayList<>(noLossPlayers), new ArrayList<>(oneLossPlayers));
	}
	
}