package fr.iutvalence.info.m2103.project.tp1.abalone;

// TODO write a comment
public class Marble {
	/**
	 * Marble color
	 */
	private final Color color;
	
	// TODO detail comment (how is the marble built?)
	/**
	 * Create a marble
	 * @param color The marble color
	 */
	public Marble(Color color){
		this.color = color;
	}
	
	// TODO finish writing comment (return tag)
	/**
	 * Return the marble color
	 */
	public Color getColor(){
		return this.color;
	}

	@Override
	public String toString() {
		if(this.color == Color.BLACK)
			return "@";
		return "O";
	}
}
