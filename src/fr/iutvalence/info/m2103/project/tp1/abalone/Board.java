package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashMap;

/**
 * This is the abalone board that manages the marble
 * 
 * @author Amaglio & Arsac
 *
 */
public class Board {
	
	private final static int MAX_PUSHABLE_MARBLE = 3;
	private final static int MARBLE_POWER = 1;
	
	/**
	 * The abalone board contains all the marbles locations. A map is used here
	 * to store marble locations only without allocating a complete table.
	 */
	private HashMap<Position, Marble> board;

	/**
	 * Sets the marbles in the classic starting position
	 */
	public Board() {
		this.setMarblesFromPresetID(0);
	}

	/**
	 * Allow user to start the game with different layouts
	 * 
	 * @param preset Id of the preset (define the marbles start locations)
	 */
	public Board(int presetId) {
		this.setMarblesFromPresetID(presetId);
	}

	/**
	 * @param preset
	 */
	private void setMarblesFromPresetID(int presetId) {
		Preset preset = Presets.preset(presetId);
		if(preset == null)
			preset = Presets.preset(0);
		
		this.board = new HashMap<Position, Marble>();
		
		Position[] blackMarblesPosition = preset.getBlackMarbles();
		Position[] whiteMarblesPosition = preset.getWhiteMarbles();
		
		for (Position position : blackMarblesPosition) {
			board.put(position, new Marble(Color.BLACK));
		}

		for (Position position : whiteMarblesPosition) {
			board.put(position, new Marble(Color.WHITE));
		}
	}

	/**
	 * Return True if the marble can go in the specified direction
	 * @param direction One of Direction enumeration
	 * @param power Specify how many marbles are moving (set this param to 1)
	 * @param attack true if marbles are pushing ennemy ones (set this param to false)
	 * @return True if the marble can go in this direction. False else
	 */
	public boolean canGo(Marble marble, Direction direction, int power, boolean attack) {

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

	/**
	 * Give the marble next to this one in the specified direction
	 * @param direction The direction to check
	 * @return The marble or null
	 */
	private Marble nextMarble(Marble marble, Direction direction) {
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

	/**
	 * Return the marble at the given location
	 * @param position
	 * @return marble
	 */
	public Marble getMarble(Position position) {
		return this.board.get(position);
	}
}
