import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;

import edu.princeton.cs.introcs.StdDraw;

public class Map {
	
	private Case[][] grille;
	
	public Map() {

		StdDraw.clear();
		StdDraw.picture(8.75, 8.5, "./src/images/RISK_menu.png", 15.5, 13);
		StdDraw.picture(9, 16, "./src/images/RISK_logo.jpg", 5, 2);
		int dimension = 20;
		String source = "./src/Territoire.txt";


		int[][] grid = new int[dimension][dimension];
		
/*		StdDraw.setPenColor(StdDraw.RED);
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid.length; y++) {
				StdDraw.square(x, y, 0.5);
			}
		}
*/		
		
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
					couleur = StdDraw.PRINCETON_ORANGE;
					break;
				case "BLUE" :
					couleur = StdDraw.BLUE;
					break;
				case "GREEN" :
					couleur = StdDraw.GREEN;
					break;
				case "PURPLE" :
					couleur = StdDraw.MAGENTA;
					break;
			}
			StdDraw.setPenColor(couleur);
			StdDraw.filledSquare(x, y, 0.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.square(x, y, 0.5);
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
		
		
		
		
		int i = 0;
		while (i <= 100000) {
			if(StdDraw.mousePressed()){
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				
				try {
					String ligne ;
					BufferedReader fichier = new BufferedReader(new FileReader(source));
				while ((ligne = fichier.readLine()) != null) {
					String values[]= ligne.split(" ");
					int x = Integer.parseInt(values[3]);
					int y = Integer.parseInt(values[4]);
					if ((x-0.5) <= xx && xx <= (x+0.5) && (y-0.25) <= yy && yy <= (y+0.25)) {
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledSquare(1, 1, 1);
						StdDraw.filledSquare(3, 1, 1);
						StdDraw.filledSquare(5, 1, 1);
						StdDraw.filledSquare(7, 1, 1);
						StdDraw.filledSquare(9, 1, 1);
						StdDraw.setPenColor(StdDraw.GRAY);
						
						StdDraw.textLeft(0.5, 1, values[5]+"  /  "+values[6]+"  "+values[1]+"  "+values[2]);
						System.out.println(values[5]+"  "+values[6]+"  "+values[1]+"  "+values[2]+"  "+xx+"  "+yy);
					}
					
				}
				fichier.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				i++;
			}
		}
		
		
		
		
		
	}
	
}
