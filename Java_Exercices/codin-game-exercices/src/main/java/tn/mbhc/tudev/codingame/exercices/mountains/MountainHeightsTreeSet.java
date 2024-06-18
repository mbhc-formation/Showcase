package tn.mbhc.tudev.codingame.exercices.mountains;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * The while loop represents the game.
 * Each iteration represents a turn of the game
 * where you are given inputs (the heights of the mountains)
 * and where you have to print an output (the index of the mountain to fire on)
 * The inputs you are given are automatically updated according to your last actions.
 **/
public class MountainHeightsTreeSet {

	public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            TreeSet<Integer> heightsTreeSet = new TreeSet<>(Comparable::compareTo);
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.

                // the value represents the index of the mountain
                heightsTreeSet.add(mountainH);
            }
            	
            // The index of the mountain to fire on.
            System.out.println(heightsTreeSet.pollLast());
        }
    }
	
}
