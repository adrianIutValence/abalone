package abalone;

import java.util.HashMap;

public class Marble {
	/**
	 * Marbles color
	 */
	private final Color color;
	
	private final HashMap<Position, Marble> board;
	
	public Marble(HashMap<Position, Marble> board, Color color){
		this.board = board;
		this.color = color;
	}
	
	
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
			if(power == 1) return false;
				return nextMarble.canGo(direction, power - 1, attack);
		}
		if(power < 3) return nextMarble.canGo(direction, power + 1, attack);
			return false;
	}


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
