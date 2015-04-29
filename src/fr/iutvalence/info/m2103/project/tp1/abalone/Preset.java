/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * This class contain all the availables start positions
 * @author Amaglio & Arsac
 *
 */
public class Preset {
	
	private final Position[] whiteMarbles;
	
	private final Position[] blackMarbles;

	/**
	 * @param whiteMarbles
	 * @param blackMarbles
	 */
	public Preset(Position[] whiteMarbles, Position[] blackMarbles) {
		this.whiteMarbles = whiteMarbles;
		this.blackMarbles = blackMarbles;
	}

	public Position[] getWhiteMarbles() {
		return whiteMarbles;
	}

	public Position[] getBlackMarbles() {
		return blackMarbles;
	}
	
	
}
