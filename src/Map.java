import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import edu.princeton.cs.introcs.StdDraw;

public class Map {
	
	private Case[][] grille;
	
	public Map() {

		try {
			BufferedReader fichier  = new BufferedReader(new FileReader("Territoire.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StdDraw.setCanvasSize(1200, 800);
		StdDraw.setScale(0, 40);
		int dimension = 20;

		int[][] grid = new int[dimension][dimension];
		while ((ligne = fichier.readLine()) != null) {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledSquare(x, y, 1);
		}
		
		grille = new Case[dimension][dimension];
		
		for (int x = 0; x < dimension; x++) {

			for (int y = 0; y < dimension; y++) {

				grille[x][y] = new Case();
			}
		}

	}
}
