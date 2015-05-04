/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * Contain all the starting positions of the different presets
 * 
 * @author Amaglio & Arsac
 *
 */
public class Presets {

	private final static Preset[] PRESETS = new Preset[] {
			new Preset(new Position[] { new Position(1, 1), new Position(1, 2),
					new Position(1, 3), new Position(1, 4), new Position(1, 5),
					new Position(2, 1), new Position(2, 2), new Position(2, 3),
					new Position(2, 4), new Position(2, 5), new Position(2, 6),
					new Position(3, 1), new Position(3, 2), new Position(3, 3),
					new Position(3, 4), new Position(3, 5), new Position(3, 6),
					new Position(3, 7), new Position(4, 1), new Position(4, 2),
					new Position(4, 3), new Position(4, 4), new Position(4, 5),
					new Position(4, 6), new Position(4, 7), new Position(4, 8),
					new Position(5, 1), new Position(5, 2), new Position(5, 3),
					new Position(5, 4), new Position(5, 5), new Position(5, 6),
					new Position(5, 7), new Position(5, 8), new Position(5, 9),
					new Position(6, 2), new Position(6, 3), new Position(6, 4),
					new Position(6, 5), new Position(6, 6), new Position(6, 7),
					new Position(6, 8), new Position(6, 9), new Position(7, 3),
					new Position(7, 4), new Position(7, 5), new Position(7, 6),
					new Position(7, 8), new Position(7, 9), new Position(8, 4),
					new Position(8, 5), new Position(8, 6), new Position(8, 7),
					new Position(8, 8), new Position(8, 9), new Position(9, 5),
					new Position(9, 6), new Position(9, 7), new Position(9, 8),
					new Position(9, 9) }, new Position[] { new Position(1, 1),
					new Position(1, 2), new Position(1, 3), new Position(1, 4),
					new Position(1, 5), new Position(2, 1), new Position(2, 2),
					new Position(2, 3), new Position(2, 4), new Position(2, 5),
					new Position(2, 6), new Position(3, 1), new Position(3, 2),
					new Position(3, 3), new Position(3, 4), new Position(3, 5),
					new Position(3, 6), new Position(3, 7), new Position(4, 1),
					new Position(4, 2), new Position(4, 3), new Position(4, 4),
					new Position(4, 5), new Position(4, 6), new Position(4, 7),
					new Position(4, 8), new Position(5, 1), new Position(5, 2),
					new Position(5, 3), new Position(5, 4), new Position(5, 5),
					new Position(5, 6), new Position(5, 7), new Position(5, 8),
					new Position(5, 9), new Position(6, 2), new Position(6, 3),
					new Position(6, 4), new Position(6, 5), new Position(6, 6),
					new Position(6, 7), new Position(6, 8), new Position(6, 9),
					new Position(7, 3), new Position(7, 4), new Position(7, 5),
					new Position(7, 6), new Position(7, 8), new Position(7, 9),
					new Position(8, 4), new Position(8, 5), new Position(8, 6),
					new Position(8, 7), new Position(8, 8), new Position(8, 9),
					new Position(9, 5), new Position(9, 6), new Position(9, 7),
					new Position(9, 8), new Position(9, 9) }),

			new Preset(
					new Position[] { new Position(1, 1), new Position(1, 2),
							new Position(1, 3), new Position(1, 4),
							new Position(1, 5), new Position(2, 1),
							new Position(2, 2), new Position(2, 3),
							new Position(2, 4), new Position(2, 5),
							new Position(2, 6), new Position(3, 3),
							new Position(3, 4), new Position(3, 5) },
					new Position[] { new Position(7, 5), new Position(7, 6),
							new Position(7, 7), new Position(8, 4),
							new Position(8, 5), new Position(8, 6),
							new Position(8, 7), new Position(8, 8),
							new Position(8, 9), new Position(9, 5),
							new Position(9, 6), new Position(9, 7),
							new Position(9, 8), new Position(9, 9) }),

			new Preset(
					new Position[] { new Position(1, 4), new Position(1, 5),
							new Position(2, 4), new Position(2, 5),
							new Position(2, 6), new Position(3, 5),
							new Position(3, 6), new Position(7, 4),
							new Position(7, 5), new Position(8, 4),
							new Position(8, 5), new Position(8, 6),
							new Position(9, 5), new Position(9, 6) },
					new Position[] { new Position(1, 1), new Position(1, 2),
							new Position(2, 1), new Position(2, 2),
							new Position(2, 3), new Position(3, 2),
							new Position(3, 3), new Position(7, 7),
							new Position(7, 8), new Position(8, 7),
							new Position(8, 8), new Position(8, 9),
							new Position(9, 8), new Position(9, 9) })

	};

	public static Preset preset(int id) {
		return PRESETS[id];
	}
}
