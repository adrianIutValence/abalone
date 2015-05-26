/**
 * 
 */
package fr.iutvalence.info.m2105.project.tp1.ihm;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iutvalence.info.m2103.project.tp1.abalone.AbaloneGame;
import fr.iutvalence.info.m2103.project.tp1.abalone.Board;
import fr.iutvalence.info.m2103.project.tp1.abalone.Marble;
import fr.iutvalence.info.m2103.project.tp1.abalone.Position;

/**
 * @author amaglioa
 *
 */
@SuppressWarnings("serial")
public class BoardDisplay extends JPanel {
	GridLayout grid;

	/**
	 * 
	 */
	public BoardDisplay(Board board) {
		this.grid = new GridLayout(17, 9);
		this.grid.setHgap(10);
		this.grid.setVgap(20);
		this.setLayout(grid);
		
		
		//TOUT DOUX :3
		for (int leftCoordinate = AbaloneGame.COORDINATES_COUNT_START; leftCoordinate <= AbaloneGame.HALF_BOARD_LEFT_COORDINATE; leftCoordinate++) {
			for (int nbSpaces = AbaloneGame.SPACES_COUNT_START; nbSpaces < AbaloneGame.HALF_BOARD_LEFT_COORDINATE - leftCoordinate; nbSpaces++)
				this.add(new JLabel(" "));
			for (int rightCoordinate = AbaloneGame.COORDINATES_COUNT_START; rightCoordinate <= (AbaloneGame.HALF_BOARD_RIGHT_COORDINATE + leftCoordinate); rightCoordinate++) {
				Marble marble = board.getMarble(new Position(leftCoordinate,
						rightCoordinate));
				if (marble == null)
					this.add(new JLabel("+"));
				else
					this.add(new JLabel(""+marble));
			}
		}
		for (int leftCoordinate = AbaloneGame.HALF_BOARD_LEFT_COORDINATE+1; leftCoordinate <= AbaloneGame.BOARD_COORDINATES; leftCoordinate++) {
			for (int nbSpaces = AbaloneGame.SPACES_COUNT_START; nbSpaces < leftCoordinate - AbaloneGame.HALF_BOARD_LEFT_COORDINATE; nbSpaces++)
				this.add(new JLabel(" "));
			for (int rightCoordinate = leftCoordinate-AbaloneGame.HALF_BOARD_RIGHT_COORDINATE; rightCoordinate <= AbaloneGame.BOARD_COORDINATES; rightCoordinate++) {
				Marble marble = board.getMarble(new Position(leftCoordinate,
						rightCoordinate));
				if (marble == null)
					this.add(new JLabel("+"));
				else
					this.add(new JLabel(""+marble));
			}
		}
	}
}
