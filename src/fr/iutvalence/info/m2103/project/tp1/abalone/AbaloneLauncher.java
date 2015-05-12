package fr.iutvalence.info.m2103.project.tp1.abalone;

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

		// TODO fix implementation: a game is not supposed to be played?
		AbaloneGame game = new AbaloneGame();
		Player[] players = new Player[] { new Player(Color.BLACK),
				new Player(Color.WHITE) };
		Player winner;
		int turn = 1;
		Movement mouvement;

		do {
			winner = game.won(players);

			System.out.println(game);
			do {
				mouvement = players[turn % Player.PLAYERS_NUMBER].waitAction();
			} while (!game.getBoard().isMouvementValid(mouvement,
					players[turn % Player.PLAYERS_NUMBER]));

			try {
				game.getBoard().move(mouvement);
			} catch (NoMarbleFound e) {
				e.printStackTrace();
			}
			turn++;
		} while (winner == null);

	}
}
