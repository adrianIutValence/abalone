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

	// TODO write a comment ;-)
	NE(-1, 0),

	/**
	 * East direction
	 * */
	E(0, 1),

	// TODO write a comment ;-)
	SE(1, 1),

	// TODO write a comment ;-)
	SW(1, 0),

	/**
	 * West direction
	 */
	W(0, -1);

	// TODO write a comment
	private final int leftDelta;
	
	// TODO write a comment
	private final int rightDelta;

	// TODO finish writing comment
	/**
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
}