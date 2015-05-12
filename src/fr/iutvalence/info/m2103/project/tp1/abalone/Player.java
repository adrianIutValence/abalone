/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author amaglioa
 *
 */
public class Player {
	
	private Color color;
	
	public Player(Color color){
		this.color = color;
	}

	/**
	 * @return
	 */
	public Mouvement waitAction() {
		Scanner scan = new Scanner(System.in);
		Mouvement mouvement;
		HashSet<Position> positions = new HashSet<Position>();
		
		System.out.println("X1,Y1, [X2, Y2, [X3, Y3,]] D");
		String[] input = scan.nextLine().split(",");
		
		for(int coordonee=0; coordonee<(input.length-1)/2; coordonee+=2){
			positions.add(new Position(Integer.parseInt(input[coordonee]), Integer.parseInt(input[coordonee+1])));
		}
		
		mouvement = new Mouvement(positions, Direction.fromStr(input[input.length]));
		return null;
	}

	/**
	 * @return
	 */
	public Color getColor() {
		return this.color;
	}
}
