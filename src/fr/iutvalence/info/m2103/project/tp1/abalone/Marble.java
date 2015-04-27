package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashMap;

// TODO write a comment
public class Marble {
	
	private final static int MAX_PUSHABLE_MARBLE = 3;
	private final static int MARBLE_POWER = 1;
	
	/**
	 * Marble color
	 */
	private final Color color;
	
	// TODO (think about it now) what the hell the marble should contain or use a board ?
	private final HashMap<Position, Marble> board;
	
	//TODO write a comment
	public Marble(HashMap<Position, Marble> board, Color color){
		this.board = board;
		this.color = color;
	}
	
	// TODO fix comment (incomplete)
	// TODO (think about it) this method should rather be placed in the game class
	/**
	 *  
	 * @param direction
	 * @param power
	 * @param attack : true if marbles are pushing ennemy ones
	 * @return True if the marble can go in this direction. False else
	 */
	public boolean canGo(int direction, int power, boolean attack){
				 
		Marble nextMarble = this.nextMarble(direction);
		
		if(nextMarble.color != this.color){
			if(attack) return false;
			return nextMarble.canGo(direction, power - MARBLE_POWER, true);
		}
		
		if(attack){
			if(power == MARBLE_POWER) return false;
				return nextMarble.canGo(direction, power - MARBLE_POWER, attack);
		}
		if(power < MAX_PUSHABLE_MARBLE) return nextMarble.canGo(direction, power + MARBLE_POWER, attack);
			return false;
	}


	// TODO fix comment (incomplete)
	/**
	 * @param direction
	 * @return
	 */
	//TOUT DOUX
	private Marble nextMarble(int direction) {
		this.board.get
		return null;
	}

}
