package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.Scanner;

import fr.iutvalence.info.m2105.project.tp1.ihm.*;

/**
 * This class launches the abalone game
 * 
 * @author Amaglio & Arsac
 *
 */
public class AbaloneLauncher {

	/**
	 * The main function that displays the menu and allows the user to play
	 * creating an AbaloneGame object
	 * 
	 * @param args
	 *            No command line args allowed yet
	 */
	public static void main(String[] args) {
		// TODO (done) fix implementation: a game is not supposed to be played?

		boolean keyPlay = true;

		Player[] players;
		Color[] colors = {Color.WHITE, Color.BLACK};
		Display[] displays;
		AbaloneGame game = new AbaloneGame();
		Player winner;
		int turn = 1;
		Movement movement;

		if (keyPlay) {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Bienvenue dans Abalone!");
			System.out.println("\n1.Nouvelle partie");

			players = new AbstractPlayer[] { new KeyboardPlayer(Color.BLACK, scan),
											 new KeyboardPlayer(Color.WHITE, scan) };
		} else {
			players = new AbstractPlayer[] { new GraphicPlayer(Color.BLACK),
											 new GraphicPlayer(Color.WHITE) };
			Window window = new Window();
			
			window.
		}

		do {
			//Display game
			if(keyPlay){
				System.out.println(game);
			}else{
				
			}

			do {
				movement = players[turn % AbstractPlayer.PLAYERS_NUMBER]
						.waitAction();
			} while (!game.getBoard().isMouvementValid(movement.copy(),
					players[turn % AbstractPlayer.PLAYERS_NUMBER]));

			try {
				game.getBoard().move(movement);
			} catch (NoMarbleFound e) {
				e.printStackTrace();
			}
			turn++;

			winner = game.won(players);
		} while (winner == null);

	}
}
