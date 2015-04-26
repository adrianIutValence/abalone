package abalone;

import java.util.HashMap;

// TODO write a comment
public class Marble {
	
	// TODO fix comment: this is not the color of all marbles, but just the color of one
	/**
	 * Marbles color
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
	 * @param attack true if marbles are pushing ennemy ones
	 * @return True if the marble can go in this direction. False else
	 */
	public boolean canGo(int direction, int power, boolean attack){
		 
		Marble nextMarble = this.nextMarble(direction);
		
		if(nextMarble.color != this.color){
			if(attack) return false;
			return nextMarble.canGo(direction, power - 1, true);
		}
		
		if(attack){
			// TODO (think about it) it is not clear what 1 means, declare a constant 
			if(power == 1) return false;
				return nextMarble.canGo(direction, power - 1, attack);
		}
		// TODO (think about it) it is not clear what 3 means, declare a constant
		if(power < 3) return nextMarble.canGo(direction, power + 1, attack);
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
