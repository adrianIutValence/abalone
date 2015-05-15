/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author adrian
 *
 */
public class KeyboardPlayer extends AbstractPlayer{
	/**
	 * @param color
	 */
	public KeyboardPlayer(Color color) {
		super(color);
	}


	/* (non-Javadoc)
	 * @see fr.iutvalence.info.m2103.project.tp1.abalone.AbstractPlayer#waitAction()
	 */
	public Movement waitAction(Scanner scan) {
		Movement mouvement;
		LinkedList<Position> positions = new LinkedList<Position>();
		
		System.out.println("X1,Y1,[X2,Y2,[X3, Y3,]]D");
		String[] input = scan.nextLine().split(",");
		
		if(input.length%2 != 1 || input.length > 7)
			return null;
		
		for(int coordonee=0; coordonee<(input.length-1); coordonee+=2){
			positions.add(new Position(Integer.parseInt(input[coordonee]), Integer.parseInt(input[coordonee+1])));
		}
		
		mouvement = new Movement(positions, Direction.fromStr(input[input.length-1]));
		return mouvement;
	}


	/* (non-Javadoc)
	 * @see fr.iutvalence.info.m2103.project.tp1.abalone.AbstractPlayer#waitAction()
	 */
	@Override
	public Movement waitAction() {
		// TODO Auto-generated method stub
		return null;
	}
}
