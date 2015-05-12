/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashSet;

/**
 * @author amaglioa
 *
 */
public class Mouvement {
	private HashSet<Position> positions;
	private Direction direction;
	
	public Mouvement(HashSet<Position> positions, Direction direction){
		this.positions= positions;
		this.direction = direction;
	}

	public HashSet<Position> getPositions() {
		return positions;
	}

	public Direction getDirection() {
		return direction;
	}

}
