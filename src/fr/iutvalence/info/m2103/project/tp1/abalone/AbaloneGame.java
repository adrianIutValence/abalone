package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * Start and manage a game
 * 
 * @author Arsac & Amaglio
 *
 */
public class AbaloneGame {

	/**
	 * The abalone board
	 */
	private Board board;

	// TODO (done) fix comment: explain what a "ready to play game" looks like
	/**
	 * return a game with a sat up board with marbles
	 */
	public AbaloneGame() {
		this.board = new Board();

	}

	/**
	 * Create a board with specific marble's start location
	 * 
	 * @param preset
	 *            Preset ID
	 */
	public AbaloneGame(int preset) {
		this.board = new Board(preset);
	}

	@Override
	/**
	 * Display the board in ascii-art
	 */
	public String toString() {
		String ret = "";

		for (int leftCoordinate = 1; leftCoordinate <= 5; leftCoordinate++) {
			for (int nbSpaces = 0; nbSpaces < 5 - leftCoordinate; nbSpaces++)
				ret += " ";
			for (int rightCoordinate = 1; rightCoordinate <= (4 + leftCoordinate); rightCoordinate++) {
				Marble marble = board.getMarble(new Position(leftCoordinate,
						rightCoordinate));
				if (marble == null)
					ret += "+ ";
				else
					ret += marble + " ";
			}
			ret += "\n";
		}
		for (int leftCoordinate = 6; leftCoordinate <= 9; leftCoordinate++) {
			for (int nbSpaces = 0; nbSpaces < leftCoordinate - 5; nbSpaces++)
				ret += " ";
			for (int rightCoordinate = leftCoordinate-4; rightCoordinate <= 9; rightCoordinate++) {
				Marble marble = board.getMarble(new Position(leftCoordinate,
						rightCoordinate));
				if (marble == null)
					ret += "+ ";
				else
					ret += marble + " ";
			}
			ret += "\n";
		}

		return ret;
	}
}
