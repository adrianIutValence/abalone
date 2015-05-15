package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.Scanner;

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
		System.out.println("Bienvenue dans Abalone!");
		System.out.println("\n1.Nouvelle partie");

		// TODO (done) fix implementation: a game is not supposed to be played?
		Scanner scan = new Scanner(System.in);
		AbaloneGame game = new AbaloneGame();
		KeyboardPlayer[] players = new KeyboardPlayer[] { new KeyboardPlayer(Color.BLACK),
				new KeyboardPlayer(Color.WHITE) };
		AbstractPlayer winner;
		int turn = 1;
		Movement movement;

		do {
			winner = game.won(players);

			System.out.println(game);
			do {
				movement = players[turn % AbstractPlayer.PLAYERS_NUMBER]
						.waitAction(scan);
			} while (!game.getBoard().isMouvementValid(movement.copy(),
					players[turn % AbstractPlayer.PLAYERS_NUMBER]));

			try {
				game.getBoard().move(movement);
			} catch (NoMarbleFound e) {
				e.printStackTrace();
			}
			turn++;
		} while (winner == null);
		scan.close();

	}
}
