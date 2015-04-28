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

	/**
	 * return a game with a set up board with marbles
	 */
	public AbaloneGame() {
		this.board = new Board();

	}
	
	/**
	 * Create a board with specific marble's starting location
	 * @param preset Preset ID
	 */
	public AbaloneGame(int preset){
		this.board = new Board(preset);
	}
 
	// TODO finish implementing this method correctly
	@Override
	/**
	 * Display the board in ascii-art
	 */
	public String toString() {
		String ret = "";
		
		for(int leftCoordinate = 1; leftCoordinate <= 9 ; leftCoordinate++){
			for(int nbSpaces = 0; nbSpaces < 5-leftCoordinate%5;)
				ret += ' ';
			for(int rightCoordinate = 1; rightCoordinate <= 9; rightCoordinate++){
				ret += "O ";
			}
			ret += "\n";
		}
		
		return "blu";
	}
}
