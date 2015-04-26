package abalone;

// TODO it should be relevant to detail in the comment the coordinate system used on the board
/**
 * Define the coordinates of a marble on the board
 */
public class Position {

	/**
	 * Left coordinate
	 */
	private int left;
	
	/**
	 * right coordinate
	 */
	private int right;
	
	// TODO fix comment (detail)
	/**
	 * Constructor
	 * @param left coordinate
	 * @param right coordinate
	 */
	public Position(int left, int right){
		this.left = left;
		this.right = right;
	}
	
	// TODO fix comment (tell chat makes position equals)
	@Override
	public boolean equals(Object obj) {
		
		if(obj == this) return true;
		if(obj == null) return false;
		if(!(obj instanceof Position)) return false;
		
		Position position = (Position) obj;
		if(position.left == this.left && position.right == this.right)
			return true;
		return false;
		
	}
	@Override
	public int hashCode() {
		return this.left*10 + this.right;
	}
}
