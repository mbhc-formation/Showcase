package tn.mbhc.tudev.codingame.exercices.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

	private BubbleSort bubbleSort;

	@BeforeEach
	public void setUp() {
		bubbleSort = new BubbleSort();
	}
	
	@Test
	void bubbleSortShuffledArray() {
		// Arrange
		int[] nums = {2,0,2,1,1,0};
		int[] expected = {0,0,1,1,2,2};
		
		// Act
		bubbleSort.execute(nums);
		
		// Assert
		assertThat(nums).isEqualTo(expected);
	}
	
	@Test
	void bubbleSortSortedArray() {
		// Arrange
		int[] nums = {0,0,1,1,2,2};
		int[] expected = {0,0,1,1,2,2};
		
		// Act
		bubbleSort.execute(nums);
		
		// Assert
		assertThat(nums).isEqualTo(expected);
	}
	
	@Test
	void bubbleSortEmptyArray() {
		// Arrange
		int[] nums = {0,0,1,1,2,2};
		int[] expected = {0,0,1,1,2,2};
		
		// Act
		bubbleSort.execute(nums);
		
		// Assert
		assertThat(nums).isEqualTo(expected);
	}
}
