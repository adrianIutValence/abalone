/**
 * 
 */
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

	NE(-1, 0),

	// TODO (done) write a comment
	/**
	 * East direction
	 * */
	E(0, 1),

	SE(1, 1),

	SW(1, 0),

	// TODO (done) write a comment
	/**
	 * West direction
	 */
	W(0, -1);

	private final int leftDelta;
	private final int rightDelta;

	/**
	 * @param leftDelta
	 * @param rightDelta
	 */
	private Direction(int leftDelta, int rightDelta) {
		this.leftDelta = leftDelta;
		this.rightDelta = rightDelta;
	}

	public int getLeftDelta() {
		return leftDelta;
	}

	public int getRightDelta() {
		return rightDelta;
	}
}