import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import edu.princeton.cs.introcs.StdDraw;

public class Map {
	
	private Case[][] grille;
	
	public Map() {

		StdDraw.setCanvasSize(1200, 800);
		StdDraw.setScale(0, 15);
		int dimension = 20;
		String source = "C:\\Users\\Guillaume ROUAIX\\Desktop\\Java_workspace\\RISK\\src\\Territoire.txt";

		int[][] grid = new int[dimension][dimension];
		
		StdDraw.setPenColor(StdDraw.RED);
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid.length; y++) {
				StdDraw.square(x, y, 0.5);
			}
		}
		
		try {
			String ligne ;
			BufferedReader fichier = new BufferedReader(new FileReader(source));
		while ((ligne = fichier.readLine()) != null) {
			String values[]= ligne.split(" ");
			int x = Integer.parseInt(values[3]);
			int y = Integer.parseInt(values[4]);
			Color couleur = null;
			switch(values[2]) {
				case "RED" :
					couleur = StdDraw.RED;
					break;
				case "YELLOW" :
					couleur = StdDraw.YELLOW;
					break;
				case "ORANGE" :
					couleur = StdDraw.ORANGE;
					break;
				case "BLUE" :
					couleur = StdDraw.BLUE;
					break;
				case "GREEN" :
					couleur = StdDraw.GREEN;
					break;
			}
			StdDraw.setPenColor(couleur);
			StdDraw.filledSquare(x, y, 0.5);
		}
		fichier.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		grille = new Case[dimension][dimension];
		
		for (int x = 0; x < dimension; x++) {

			for (int y = 0; y < dimension; y++) {

				grille[x][y] = new Case();
			}
		}
		
	}
	

	
}
