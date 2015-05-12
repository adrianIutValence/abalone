/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashSet;

/**
 * this class define an abalone movement.
 * 
 * @author amaglioa
 *
 */
public class Movement {
	/**
	 * A set that include 1 to 3 marble positions. If there is only one position, it's a pushing movement. It's a lateral one else.
	 */
	private HashSet<Position> positions;
	
	/**
	 * The movement direction
	 */
	private Direction direction;
	
	
	/**
	 * Create a movement 
	 * @param positions the position(s)
	 * @param direction the direction
	 */
	public Movement(HashSet<Position> positions, Direction direction){
		this.positions = positions;
		this.direction = direction;
	}
	
	/**
	 * Positions getter
	 * @return the movement potition(s)
	 */
	public HashSet<Position> getPositions() {
		return positions;
	}
	
	/**
	 * Return the first element of the Position set
	 * To use if there is only one element
	 * @return The element of the Positions set
	 */
	public Position getFirstPosition(){
		for(Position position : this.positions)
			return position;
		//Java won't execute without this line :
		return null;
	}
	
	/**
	 * Direction getter
	 * @return the movement direction
	 */
	public Direction getDirection() {
		return this.direction;
	}

}
