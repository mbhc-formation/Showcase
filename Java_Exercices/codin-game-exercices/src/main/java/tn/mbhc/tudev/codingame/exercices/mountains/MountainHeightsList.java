package tn.mbhc.tudev.codingame.exercices.mountains;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * The while loop represents the game. Each iteration represents a turn of the
 * game where you are given inputs (the heights of the mountains) and where you
 * have to print an output (the index of the mountain to fire on) The inputs you
 * are given are automatically updated according to your last actions.
 **/
public class MountainHeightsList {
	
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {

			// game loop
			while (true) {

				List<Integer> heights = new ArrayList<>();
				for (int i = 0; i < 8; i++) {
					// represents the height of one mountain.
					int mountainH = in.nextInt();

					// since the map is ordered on keys, we can use the mountain height as the key
					// and the value represents the index of the mountain
					heights.add(mountainH);
				}

				Optional<Integer> max = heights.stream().max(Comparable::compareTo);
				if (max.isPresent()) {
					// The index of the mountain to fire on.
					System.out.println(max.get());
					
					// Once a mountain is destroyed we remove its value from the list
					heights.remove(heights.indexOf(max.get()));
				}
				
				// Stop the game loop if all mountains are destroyed
				if(heights.isEmpty()) {
					break;
				}
			}

		}
	}

}
