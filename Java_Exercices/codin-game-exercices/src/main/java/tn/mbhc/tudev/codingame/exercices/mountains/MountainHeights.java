package tn.mbhc.tudev.codingame.exercices.mountains;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * The while loop represents the game. Each iteration represents a turn of the
 * game where you are given inputs (the heights of the mountains) and where you
 * have to print an output (the index of the mountain to fire on) The inputs you
 * are given are automatically updated according to your last actions.
 **/
public class MountainHeights {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			TreeMap<Integer, Integer> heightsTreeMap = new TreeMap<>(Comparable::compareTo);
			for (int i = 0; i < 8; i++) {
				// represents the height of one mountain.
				int mountainH = in.nextInt();

				// since the map is ordered on keys, we can use the mountain height as the key
				// and the value represents the index of the mountain
				heightsTreeMap.put(mountainH, i);
			}

			// The index of the mountain to fire on.
			System.out.println(heightsTreeMap.pollLastEntry().getValue());
		}
	}

}
