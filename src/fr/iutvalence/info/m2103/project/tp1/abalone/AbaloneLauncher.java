package fr.iutvalence.info.m2103.project.tp1.abalone;

//TODO (done) write a comment
/**
 * This Class launch the abalone game
 * @author Amaglio & Arsac
 *
 */
public class AbaloneLauncher {

	// TODO (done) write a comment
	/**
	 * The main function that display the menu and allow the user to play creating an AbaloneGame object
	 * @param args No command line args allowed yet
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenue dans Abalone!");
		System.out.println("\n1.Nouvelle partie");
		
		// TODO fix implementation: a game is not supposed to be played?
		AbaloneGame game = new AbaloneGame();
		
		System.out.print(game);

	}

}
