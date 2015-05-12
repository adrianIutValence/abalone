package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

	private Set<Position> validPositions;

	/**
	 * Sets the marbles in the classic starting position
	 */
	public Board() {
		this.setMarblesFromPresetID(1);
		this.init();
	}

	/**
	 * Allow user to start the game with different layouts
	 * 
	 * @param preset
	 *            Id of the preset (define the marbles start locations)
	 */
	public Board(int presetId) {
		this.setMarblesFromPresetID(presetId);
		this.init();
	}

	/**
	 * 
	 */
	private void init() {

		validPositions = new HashSet<Position>();
		validPositions.add(new Position(1, 1));
		validPositions.add(new Position(1, 2));
		validPositions.add(new Position(1, 3));
		validPositions.add(new Position(1, 4));
		validPositions.add(new Position(1, 5));
		validPositions.add(new Position(2, 1));
		validPositions.add(new Position(2, 2));
		validPositions.add(new Position(2, 3));
		validPositions.add(new Position(2, 4));
		validPositions.add(new Position(2, 5));
		validPositions.add(new Position(2, 6));
		validPositions.add(new Position(3, 1));
		validPositions.add(new Position(3, 2));
		validPositions.add(new Position(3, 3));
		validPositions.add(new Position(3, 4));
		validPositions.add(new Position(3, 5));
		validPositions.add(new Position(3, 6));
		validPositions.add(new Position(3, 7));
		validPositions.add(new Position(4, 1));
		validPositions.add(new Position(4, 2));
		validPositions.add(new Position(4, 3));
		validPositions.add(new Position(4, 4));
		validPositions.add(new Position(4, 5));
		validPositions.add(new Position(4, 6));
		validPositions.add(new Position(4, 7));
		validPositions.add(new Position(4, 8));
		validPositions.add(new Position(5, 1));
		validPositions.add(new Position(5, 2));
		validPositions.add(new Position(5, 3));
		validPositions.add(new Position(5, 4));
		validPositions.add(new Position(5, 5));
		validPositions.add(new Position(5, 6));
		validPositions.add(new Position(5, 7));
		validPositions.add(new Position(5, 8));
		validPositions.add(new Position(5, 9));
		validPositions.add(new Position(6, 2));
		validPositions.add(new Position(6, 3));
		validPositions.add(new Position(6, 4));
		validPositions.add(new Position(6, 5));
		validPositions.add(new Position(6, 6));
		validPositions.add(new Position(6, 7));
		validPositions.add(new Position(6, 8));
		validPositions.add(new Position(6, 9));
		validPositions.add(new Position(7, 3));
		validPositions.add(new Position(7, 4));
		validPositions.add(new Position(7, 5));
		validPositions.add(new Position(7, 6));
		validPositions.add(new Position(7, 7));
		validPositions.add(new Position(7, 8));
		validPositions.add(new Position(7, 9));
		validPositions.add(new Position(8, 4));
		validPositions.add(new Position(8, 5));
		validPositions.add(new Position(8, 6));
		validPositions.add(new Position(8, 7));
		validPositions.add(new Position(8, 8));
		validPositions.add(new Position(8, 9));
		validPositions.add(new Position(9, 5));
		validPositions.add(new Position(9, 6));
		validPositions.add(new Position(9, 7));
		validPositions.add(new Position(9, 8));
		validPositions.add(new Position(9, 9));
	}

	// TODO (done) finish writing comment
	/**
	 * Set marbles on the board depending of the coordinates stored in the
	 * wanted preset
	 * 
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
	public boolean canGo(Mouvement mouvement, int power, boolean attack)
			throws NoMarbleFound {
		if (mouvement.getPositions().size() != 1) {
			for (Position position : mouvement.getPositions()) {
				if (this.getMarble(this.nextMarblePosition(position,
						mouvement.getDirection())) != null
						&& !this.onTheBoard(this.nextMarblePosition(position,
								mouvement.getDirection())))
					return false;
			}
			return true;
		} else {
			Position position = mouvement.getPositions()[0];
			Direction direction = mouvement.getDirection();

			// If there is no marble at this position
			if (this.getMarble(position) == null)
				throw new NoMarbleFound();

			Position nextMarblePosition = this.nextMarblePosition(position,
					direction);

			// if no marble detected
			if (this.getMarble(nextMarblePosition) == null) {
				if (attack) {
					return power >= 1;
				}
				if (power <= MAX_PUSHABLE_MARBLE
						&& this.onTheBoard(nextMarblePosition))
					return true;
				return false;
			}

			if (this.getMarble(nextMarblePosition).getColor() != this
					.getMarble(position).getColor()) {
				if (attack)
					return false;
				return this.canGo(mouvement, power - MARBLE_POWER, true);
			}

			if (attack) {
				if (power <= MARBLE_POWER)
					return false;
				return this.canGo(mouvement, power - MARBLE_POWER, attack);
			}
			if (power < MAX_PUSHABLE_MARBLE)
				return this.canGo(mouvement, power + MARBLE_POWER, attack);
			return false;
		}
	}

	public void move(Mouvement mouvement) throws NoMarbleFound {

		if (!canGo(mouvement, 1, false))
			return;

		if (mouvement.getPositions().size() != 1) {
			for (Position position : mouvement.getPositions()) {
				this.put(
						this.nextMarblePosition(position,
								mouvement.getDirection()),
						this.getMarble(position));
				this.removeMarble(position);
			}
		} else {
			
			Position marblePosition = mouvement.getPositions()[0];

			Marble marbleToPlace = null, marbleToReplace;
			Position currentPosition = marblePosition;

			while (this.getMarble(currentPosition) != null) {
				marbleToReplace = this.getMarble(currentPosition);
				this.removeMarble(marblePosition);
				this.put(currentPosition, marbleToPlace);
				marbleToPlace = marbleToReplace;

				currentPosition = this.nextMarblePosition(currentPosition,
						mouvement.getDirection());

			}
			this.put(currentPosition, marbleToPlace);
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
		return this.validPositions.contains(position);
	}
	
	public boolean isMouvementValid(Mouvement mouvement, Player player){
		for(Position position : mouvement.getPositions()){
			if(this.getMarble(position).getColor() != player.getColor())
				return false;
		}
		
		
		return true;
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
		if (marble == null)
			return;
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
