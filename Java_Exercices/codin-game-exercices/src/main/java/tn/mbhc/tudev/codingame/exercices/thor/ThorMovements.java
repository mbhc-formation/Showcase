package tn.mbhc.tudev.codingame.exercices.thor;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement. --- Hint: You can use the debug stream to
 * print initialTX and initialTY, if Thor seems not follow your orders.
 **/
public class ThorMovements {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int lightX = in.nextInt(); // the X position of the light of power
			int lightY = in.nextInt(); // the Y position of the light of power
			int initialTx = in.nextInt(); // Thor's starting X position
			int initialTy = in.nextInt(); // Thor's starting Y position

			// game loop
			int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this
			while (remainingTurns > 0) {
													// line.

				while (remainingTurns > 0) {
					StringBuilder commandBuilder = new StringBuilder();
					// Check position on Y axis
	                if(initialTy > lightY) {
	                    commandBuilder.append("N");
	                    initialTy--;
	                } else if(initialTy < lightY) {
	                    commandBuilder.append("S");
	                    initialTy++;
	                }

	                // Check position on X axis
	                if(initialTx > lightX) {
	                    commandBuilder.append("W");
	                    initialTx++;
	                } else if(initialTx < lightX) {
	                    commandBuilder.append("E");
	                    initialTx--;
	                }
	                	
	                new TreeSet<>((Integer o1, Integer o2) -> {
						if(Math.abs(o1) > Math.abs(o2)) {
							return 1;
						} else if(Math.abs(o1) < Math.abs(o2)) {
							return -1;
						} else {
							return 0;
						}
					});
	                
	                // A single line providing the move to be made: N NE E SE S SW W or NW
	                System.out.println(commandBuilder.toString());
					remainingTurns--;
				}
			}
		}
	}
}
