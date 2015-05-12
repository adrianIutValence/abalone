/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This class define an abalone player
 * @author amaglioa
 *
 */
public class Player {
	
	/**
	 * Number of players that actually play the game
	 */
	public static final int PLAYERS_NUMBER = 2;
	/**
	 * The color of players marbles
	 */
	private Color color;
	
	/**
	 * Create a new player
	 * @param color the color of the player
	 */
	public Player(Color color){
		this.color = color;
	}

	/**
	 * This method wait for an user input and create the movement that correspond.
	 * @return the movement to validate and execute
	 */
	public Movement waitAction(Scanner scan) {
		Movement mouvement;
		HashSet<Position> positions = new HashSet<Position>();
		
		System.out.println("X1,Y1, [X2, Y2, [X3, Y3,]] D");
		String[] input = scan.nextLine().split(",");
		
		if(input.length%2 != 1 || input.length > 7)
			return null;
		
		for(int coordonee=0; coordonee<(input.length-1); coordonee+=2){
			positions.add(new Position(Integer.parseInt(input[coordonee]), Integer.parseInt(input[coordonee+1])));
		}
		
		mouvement = new Movement(positions, Direction.fromStr(input[input.length-1]));
		return mouvement;
	}

	/**
	 * Return the players color
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}
}
