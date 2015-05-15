package fr.iutvalence.info.m2103.project.tp1.abalone;

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

		boolean keyPlay = false;

		AbstractPlayer[] players;
		AbaloneGame game = new AbaloneGame();
		AbstractPlayer winner;
		int turn = 1;
		Movement movement;

		if (keyPlay) {
			System.out.println("Bienvenue dans Abalone!");
			System.out.println("\n1.Nouvelle partie");

			players = new AbstractPlayer[] { new KeyboardPlayer(Color.BLACK),
					new KeyboardPlayer(Color.WHITE) };
		} else {
			players = new AbstractPlayer[] { new GraphicPlayer(Color.BLACK),
					new GraphicPlayer(Color.WHITE) };
			Window window = new Window();
		}

		do {
			winner = game.won(players);

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
		} while (winner == null);

	}
}
