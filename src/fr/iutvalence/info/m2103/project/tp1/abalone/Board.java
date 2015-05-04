package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashMap;

/**
 * This is the abalone board that manages the marble
 * 
 * @author Amaglio & Arsac
 *
 */
public class Board {
	
	// TODO write a comment
	private final static int MAX_PUSHABLE_MARBLE = 3;
	
	// TODO write a comment
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
		this.setMarblesFromPresetID(1);
	}

	/**
	 * Allow user to start the game with different layouts
	 * 
	 * @param preset
	 *            Id of the preset (define the marbles start locations)
	 */
	public Board(int presetId) {
		this.setMarblesFromPresetID(presetId);
	}

	// TODO (done) finish writing comment
	/**
	 * Set marbles on the board depending of the coordinates stored in the wanted preset
	 * @param preset
	 */
	private void setMarblesFromPresetID(int presetId) {
		Preset preset = Presets.preset(presetId);
		if (preset == null)
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
	 * 
	 * @param direction
	 *            One of Direction enumeration
	 * @param power
	 *            Specify how many marbles are moving (set this param to 1)
	 * @param attack
	 *            true if marbles are pushing ennemy ones (set this param to
	 *            false)
	 * @return True if the marble can go in this direction. False else
	 */
	public boolean canGo(Position position, Direction direction, int power,
			boolean attack) throws NoMarbleFound{
		//If there is no marble at this position
		if(this.getMarble(position) == null)
			throw new NoMarbleFound();

		Position nextMarblePosition = this.nextMarblePosition(position,
				direction);

		//if no marble detected
		if(this.getMarble(nextMarblePosition) == null){
			if(attack){
				return power >= 1;
			}
			if (power <= MAX_PUSHABLE_MARBLE && this.onTheBoard(nextMarblePosition))
				return true;
			return false;
		}
		

		if (this.getMarble(nextMarblePosition).getColor() != this.getMarble(
				position).getColor()) {
			if (attack)
				return false;
			return this.canGo(nextMarblePosition, direction, power
					- MARBLE_POWER, true);
		}

		if (attack) {
			if (power <= MARBLE_POWER)
				return false;
			return this.canGo(nextMarblePosition, direction, power
					- MARBLE_POWER, attack);
		}
		if (power < MAX_PUSHABLE_MARBLE)
			return this.canGo(nextMarblePosition, direction, power
					+ MARBLE_POWER, attack);
		return false;
	}
	
	//TOUT DOUX
	public void move(Position marblePosition, Direction direction) throws NoMarbleFound{
		if (!canGo(marblePosition, direction, 1, false))
			return;
		
		
		Marble marbleToMove = this.getMarble(nextMarblePosition(marblePosition, direction));
		removeMarble(marblePosition);
		while(this.getMarble(nextMarblePosition(marblePosition, direction)) != null){
			
		}
	}
	

	/**
	 * @param marblePosition
	 */
	private void removeMarble(Position position) {
		this.board.remove(position);
		
	}

	/**
	 * @param nextMarblePosition
	 * @return
	 */
	private boolean onTheBoard(Position position) {
		Position[] list = Presets.preset(0).getWhiteMarbles();
		for (Position positionToTest : list){
			//System.out.println(positionToTest + " " + position);
			if(position.equals(positionToTest))
				return true;
		}
		return false;
	}

	/**
	 * Give the marble next to this one in the specified direction. null else
	 * 
	 * @param direction
	 *            The direction to check
	 * @return The marble or null
	 */
	private Position nextMarblePosition(Position position, Direction direction) {
		return new Position(position.getLeft() + direction.getLeftDelta(),
				position.getRight() + direction.getRightDelta());
	}

	/**
	 * Insert a marble on the board at the specified position
	 * 
	 * @param position
	 *            Where the marble should be placed
	 * @param marble
	 *            The marble
	 */
	public void put(Position position, Marble marble) {
		this.board.put(position, marble);
	}

	/**
	 * Return the marble at the given location
	 * 
	 * @param position
	 * @return marble
	 */
	public Marble getMarble(Position position) {
		return this.board.get(position);
	}
}
