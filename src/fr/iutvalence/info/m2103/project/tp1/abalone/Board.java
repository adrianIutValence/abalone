package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashMap;

/**
 * This is the abalone board that manage the marble
 * 
 * @author Amaglio & Arsac
 *
 */
public class Board {
	
	private final static int MAX_PUSHABLE_MARBLE = 3;
	private final static int MARBLE_POWER = 1;
	
	/**
	 * The abalone board It contains all the marbles location A map is used here
	 * to store marble location only without allocate a compete table.
	 */
	private HashMap<Position, Marble> board;

	/**
	 * Sets the marbles in the classic start position
	 */
	public Board() {
		this.board = new HashMap<Position, Marble>();
		
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
			this.board.put(position, new Marble(Color.BLACK));
		}

		for (Position position : whiteMarblesPosition) {
			this.board.put(position, new Marble(Color.WHITE));
		}
	}

	// TODO make a preset class
	/**
	 * Allow user to start the game with different layouts
	 * 
	 * @param preset Id of the preset (define the marbles start locations)
	 */
	public Board(int preset) {
		
		Position[] blackMarblesPosition = { new Position(1, 1),
				new Position(1, 2), new Position(2, 1), new Position(2, 2),
				new Position(2, 3), new Position(3, 2), new Position(3, 3),
				new Position(7, 7), new Position(7, 8), new Position(8, 7),
				new Position(8, 8), new Position(8, 9), new Position(9, 8),
				new Position(9, 9) };
		Position[] whiteMarblesPosition = { new Position(1, 4),
				new Position(1, 5), new Position(2, 4), new Position(2, 5),
				new Position(2, 6), new Position(3, 5), new Position(3, 6),
				new Position(7, 4), new Position(7, 5), new Position(8, 4),
				new Position(8, 5), new Position(8, 6), new Position(9, 5),
				new Position(9, 6) };
		
		for (Position position : blackMarblesPosition) {
			board.put(position, new Marble(Color.BLACK));
		}

		for (Position position : whiteMarblesPosition) {
			board.put(position, new Marble(Color.WHITE));
		}
	}

	// TODO (done) fix comment (incomplete)
	// TODO (done) (think about it) this method should rather be placed in the game
	// class
	/**
	 * Return True if the marble can go in the specified direction
	 * @param direction One of Direction enumeration
	 * @param power Specify how many marbles are moving (set this param to 1)
	 * @param attack true if marbles are pushing ennemy ones (set this param to false)
	 * @return True if the marble can go in this direction. False else
	 */
	public boolean canGo(Marble marble, int direction, int power, boolean attack) {

		Marble nextMarble = this.nextMarble(marble, direction);

		if (nextMarble.getColor() != marble.getColor()) {
			if (attack)
				return false;
			return this.canGo(nextMarble, direction, power - MARBLE_POWER, true);
		}

		if (attack) {
			if (power == MARBLE_POWER)
				return false;
			return this.canGo(nextMarble, direction, power - MARBLE_POWER, attack);
		}
		if (power < MAX_PUSHABLE_MARBLE)
			return this.canGo(nextMarble, direction, power + MARBLE_POWER, attack);
		return false;
	}

	// TODO (done) fix comment (incomplete)
	// TODO Complete this function
	/**
	 * Give the marble next to "marble" in the specified direction
	 * @param direction The direction to check
	 * @return The marble or null
	 */
	private Marble nextMarble(Marble marble, int direction) {
			
			return marble;
		}
	
	/**
	 * Insert a marble on the board at the specified position
	 * @param position Where the marble should be placed
	 * @param marble The marble
	 */
	public void put(Position position, Marble marble){
		this.board.put(position, marble);		
	}
}
