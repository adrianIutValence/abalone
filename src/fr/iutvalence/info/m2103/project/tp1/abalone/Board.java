package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashMap;

/**
 * This is the abalone board that manage the marble
 * 
 * @author Amaglio & Arsac
 *
 */
public class Board {
	/**
	 * The abalone board It contains all the marbles location A map is used here
	 * to store marble location only without allocate a compete table.
	 */
	HashMap<Position, Marble> board;

	/**
	 * Sets the marbles in the classic start position
	 */
	public Board() {
		Position[] blackMarblesPosition = { new Position(7, 5),
				new Position(7, 6), new Position(7, 7), new Position(8, 4),
				new Position(8, 5), new Position(8, 6), new Position(8, 7),
				new Position(8, 8), new Position(8, 9), new Position(9, 5),
				new Position(9, 6), new Position(9, 7), new Position(9, 8),
				new Position(9, 9) };
		Position[] whiteMarblesPosition = { new Position(1, 1),
				new Position(1, 2), new Position(1, 3), new Position(1, 4),
				new Position(1, 5), new Position(2, 1), new Position(2, 2),
				new Position(2, 3), new Position(2, 4), new Position(2, 5),
				new Position(2, 6), new Position(3, 3), new Position(3, 4),
				new Position(3, 5) };

		for (Position position : blackMarblesPosition) {
			board.put(position, new Marble(Color.BLACK));
		}

		for (Position position : whiteMarblesPosition) {
			board.put(position, new Marble(Color.WHITE));
		}
	}

	// TODO make a preset class
	public Board(int preset) {
		Position[] blackMarblesPosition = { new Position(1, 1),
				new Position(1, 2), new Position(2, 1), new Position(2, 2),
				new Position(2, 3), new Position(3, 2), new Position(3, 3),
				new Position(7, 7), new Position(7, 8), new Position(8, 7),
				new Position(8, 8), new Position(8, 9), new Position(9, 8),
				new Position(9, 9) };
	}
}
