/**
 * 
 */
package fr.iutvalence.info.m2105.project.tp1.ihm;

import fr.iutvalence.info.m2103.project.tp1.abalone.Board;

/**
 * @author amaglioa
 *
 */
public class GUI implements Runnable{
	Window window;
	BoardDisplay boardDisplay;
	Board board;
	
	public GUI(Board board){
		this.board = board;
	}
	
	public void run(){
		this.window = new Window();
		this.boardDisplay = new BoardDisplay(this.board);
		this.window.add(this.boardDisplay);
		this.window.setVisible(true);

	}

	/**
	 * Refresh the board after the movement
	 */
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
}