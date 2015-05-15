/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * This class define an abalone player
 * @author amaglioa
 *
 */
public abstract class AbstractPlayer {
	
	/**
	 * Number of players that actually play the game
	 */
	public static final int PLAYERS_NUMBER = 2;
	/**
	 * The color of players marbles
	 */
	private Color color;
	
	/**
	 * Create a new player
	 * @param color the color of the player
	 */
	public AbstractPlayer(Color color){
		this.color = color;
	}

	/**
	 * This method waits for an user input and create the movement that correspond.
	 * @return the movement to validate and execute
	 */
	public abstract Movement waitAction();

	/**
	 * Return the players color
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}
}
