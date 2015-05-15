package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * enumerates the possible movement directions of the marble
 * 
 * @author Amaglio & Arsac
 */
public enum Direction {
	/**
	 * North direction Northern west direction
	 */
	NW(-1, -1),

	// TODO (done :3)write a comment ;-)
	/**
	 * Northern East direction
	 * */
	NE(-1, 0),

	/**
	 * East direction
	 * */
	E(0, 1),

	// TODO (done :3)write a comment ;-)
	/**
	 * Southern East direction
	 * */
	SE(1, 1),

	// TODO (done :3)write a comment ;-)
	/**
	 * Southern West direction
	 * */
	SW(1, 0),

	/**
	 * West direction
	 */
	W(0, -1);

	// TODO (done) write a comment
	/**
	 * Left coordinate difference for the marble that will go in this direction
	 */
	private final int leftDelta;
	
	// TODO (done) write a comment
	/**
	 * Left coordinate difference for the marble that will go in this direction
	 */
	private final int rightDelta;

	// TODO finish writing comment
	/**
	 * 
	 * @param leftDelta
	 * @param rightDelta
	 */
	private Direction(int leftDelta, int rightDelta) {
		this.leftDelta = leftDelta;
		this.rightDelta = rightDelta;
	}

	// TODO write a comment
	public int getLeftDelta() {
		return leftDelta;
	}

	// TODO write a comment
	public int getRightDelta() {
		return rightDelta;
	}

	/**
	 * Convert a String in a direction. The string have to be equals to the constant name.
	 * Example : fromStr(new String("NE")) returns Direction.NE
	 * @param string
	 * @return the direction that correspond to the param str
	 */
	public static Direction fromStr(String string) {
		//The case statement does not compare String objects
		if(string.equals("NE"))
			return NE;
		else if(string.equals("NW"))
			return NW;
		else if(string.equals("SE"))
			return SE;
		else if(string.equals("SW"))
			return SW;
		else if(string.equals("E"))
			return E;
		else if(string.equals("W"))
			return W;
		return null;
	}

}