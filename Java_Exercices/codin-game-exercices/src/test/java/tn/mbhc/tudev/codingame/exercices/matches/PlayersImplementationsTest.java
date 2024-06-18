package tn.mbhc.tudev.codingame.exercices.matches;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import tn.mbhc.tudev.codingame.exercices.matches.helper.MatchesTestFilesHelper;
import tn.mbhc.tudev.codingame.exercices.matches.impl.PlayersImplFactory;
import tn.mbhc.tudev.codingame.exercices.matches.impl.PlayersImplFactory.ImplmentationUsing;

class PlayersImplementationsTest {

	static Stream<IPlayers> playersImplmentationsProvider() {
        return Stream.of(PlayersImplFactory.create(ImplmentationUsing.MAP), PlayersImplFactory.create(ImplmentationUsing.SET));
    }
	
	@ParameterizedTest
	@MethodSource("playersImplmentationsProvider")
	void timeExceedingTest(IPlayers players) throws IOException {
		
		// Arrange
		String matchesFile = PlayersImplementationsTest.class.getClassLoader().getResource("time_consuming_players_test_matches.txt").getFile();
		int[][] matches = MatchesTestFilesHelper.lireFichierEtCreerTableau(matchesFile);
		
		String resultsFile = PlayersImplementationsTest.class.getClassLoader().getResource("time_consuming_players_test_expected_results.txt").getFile();
		List<List<Integer>> results = MatchesTestFilesHelper.lireFichierResultats(resultsFile);
		
		// Act
		List<List<Integer>> result = players.findWinners(matches);

		// Assert
		assertThat(result).isEqualTo(results);
	}
	
	@ParameterizedTest
	@MethodSource("playersImplmentationsProvider")
	void multipleMatches_MultipleWinners_NoLosers(IPlayers players) {
		// Arrange
		int[][] matches = { {1,5}, {2,5}, {2,8}, {2,9}, {3,8}, {4,7}, {4,9}, {5,7}, {6,8} };
		List<List<Integer>> expected = List.of(List.of(1, 2, 3, 4, 6), Collections.emptyList());
		
		// Act
		List<List<Integer>> result = players.findWinners(matches);
		
		// Assert
		assertThat(result).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("playersImplmentationsProvider")
	void multipleMatches_NoWinners_NoLosers(IPlayers players) {
		// Arrange
		int[][] matches = { {1,2}, {2,1}, {1,3}, {3,1}, {2,3}, {3,2} };
		List<List<Integer>> expected = List.of(Collections.emptyList(), Collections.emptyList());
		
		// Act
		List<List<Integer>> result = players.findWinners(matches);
		
		// Assert
		assertThat(result).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("playersImplmentationsProvider")
	void oneMatch_OneWinner_OneLoser(IPlayers players) {
		// Arrange
		int[][] matches = { {1,3} };
		List<List<Integer>> expected = List.of(List.of(1), List.of(3));
		
		// Act
		List<List<Integer>> result = players.findWinners(matches);
		
		// Assert
		assertThat(result).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("playersImplmentationsProvider")
	void twoMatches_TwoWinners_NoLoserWithExactlyOneLoss(IPlayers players) {
		// Arrange
		int[][] matches = { {1,3}, {2,3} };
		List<List<Integer>> expected = List.of(List.of(1, 2), Collections.emptyList());
		
		// Act
		List<List<Integer>> result = players.findWinners(matches);
		
		// Assert
		assertThat(result).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("playersImplmentationsProvider")
	void multipleMatches_MultipleWinners_MultipleLosersWithExactlyOneLoss(IPlayers players) {
		// Arrange
		int[][] matches = { {1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9} };
		
		List<List<Integer>> expected = List.of(List.of(1, 2, 10), List.of(4, 5, 7, 8));
		
		// Act
		List<List<Integer>> result = players.findWinners(matches);
		
		// Assert
		assertThat(result).isEqualTo(expected);
	}
}
