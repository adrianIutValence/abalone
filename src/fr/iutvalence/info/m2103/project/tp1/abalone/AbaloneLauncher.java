package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * This class launches the abalone game
 * @author Amaglio & Arsac
 *
 */
public class AbaloneLauncher {

	/**
	 * The main function that displays the menu and allows the user to play creating an AbaloneGame object
	 * @param args No command line args allowed yet
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenue dans Abalone!");
		System.out.println("\n1.Nouvelle partie");
		
		// TODO fix implementation: a game is not supposed to be played?
		AbaloneGame game = new AbaloneGame();
		
		System.out.print(game);
		try {
			System.out.println(game.getBoard().canGo(new Position(2, 1), Direction.E, 1, false));
		} catch (NoMarbleFound e) {
			System.out.println("NoMarbleFound Exception");
		}

	}

}
