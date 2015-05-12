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


	public Board getBoard() {
		return board;
	}

	/**
	 * return a game with a set up board with marbles
	 */
	public AbaloneGame() {
		this.board = new Board(0);
	}

	/**
	 * Create a board with specific marble's starting location
	 * @param preset Preset ID
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

		// TODO replace hard-coded numbers with constants if possible
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

	/**
	 * Test if a game is won
	 * @return the player that won the game
	 */
	public Player won(Player[] players) {
		for(int count = 0; count< players.length; count++){
			if(this.board.countMarbles(players[count].getColor()) < this.board.MAX_MARBLES - this.board.MARBLES_TO_WIN)
				return players[count%Player.PLAYERS_NUMBER];
		}
		return null;
	}

}
