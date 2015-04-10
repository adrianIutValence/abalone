package abalone;

import java.util.HashMap;

/**
 * Start and manage a game
 * @author amaglioa
 *
 */
public class AbaloneGame {
	
	/**
	 * Map object that stores the marbles references sorted with positions
	 */
	HashMap<Position, Marble> board;
	
	/**
	 * return a ready to play game
	 */
	public AbaloneGame(){
		this.board = new HashMap<Position, Marble>();
		this.setMarbles();
		
	}
	
	/**
	 * place the marbles on the board
	 */
	private void setMarbles(){
		Position[] blackMarblesPosition = {new Position(7,5), new Position(7,6), new Position(7,7), new Position(8,4), new Position(8,5), new Position(8,6), new Position(8,7), new Position(8,8), new Position(8,9), new Position(9,5), new Position(9,6), new Position(9,7), new Position(9,8), new Position(9,9)};
		Position[] whiteMarblesPosition = {new Position(1,1), new Position(1,2), new Position(1,3), new Position(1,4), new Position(1,5), new Position(2,1), new Position(2,2), new Position(2,3), new Position(2,4), new Position(2,5), new Position(2,6), new Position(3,3), new Position(3,4), new Position(3,5)};
	
		for(Position position : blackMarblesPosition){
			board.put(position, new Marble(Color.BLACK));
		}
		
		for(Position position : whiteMarblesPosition){
			board.put(position, new Marble(Color.WHITE));
		}
	}
	
	
}
