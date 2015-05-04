/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * This class contain all the available starting positions
 * @author Amaglio & Arsac
 *
 */
public class Preset {
	
	
	// TODO write a comment
	private final Position[] whiteMarbles;

	// TODO write a comment
	private final Position[] blackMarbles;

	// TODO finsih writing comment
	/**
	 * @param whiteMarbles
	 * @param blackMarbles
	 */
	public Preset(Position[] whiteMarbles, Position[] blackMarbles) {
		this.whiteMarbles = whiteMarbles;
		this.blackMarbles = blackMarbles;
	}

	// TODO write a comment
	public Position[] getWhiteMarbles() {
		return whiteMarbles;
	}

	// TODO write a comment
	public Position[] getBlackMarbles() {
		return blackMarbles;
	}
}
