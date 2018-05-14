import edu.princeton.cs.introcs.StdDraw;

public class Map {
	
	private Case[][] grille;
	
	public Map() {
		StdDraw.setCanvasSize(1920, 1080);
		StdDraw.setScale(0, 20);
		int dimension = 20;

		int[][] grid = new int[dimension][dimension];

		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid.length; y++) {
				StdDraw.square(x, y, 3);
			}
		}
		
		grille = new Case[dimension][dimension];

		for (int x = 0; x < dimension; x++) {

			for (int y = 0; y < dimension; y++) {

				grille[x][y] = new Case();
			}
		}

	}
}
