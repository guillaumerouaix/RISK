import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Map {
	
	Territoire [] tabTerritoire;
	String source = "./src/Territoire.txt";
	int nbTerritoireJoueur;

	public Map(int nbJoueur) {
		
//mise à blanc de la fenêtre, affichage du logo et icon
		StdDraw.clear();
		StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
		StdDraw.picture(9, 16, "./src/images/RISK_logo.jpg", 5, 2);
		StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
		StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
		StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
		StdDraw.picture(15, 3, "./src/images/RISK_boutton_fin_tour.png", 3, 1.5);
		
		
/*		affichage de la grille
 		StdDraw.setPenColor(StdDraw.RED);
 		
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid.length; y++) {
				StdDraw.square(x, y, 0.5);
			}
		}
*/		
		
		
//affichage mape graphique
		tabTerritoire  = new Territoire[42];
		Random r = new Random();
		int i = 0;
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
					couleur = StdDraw.CYAN;
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
			
//creation des territoires
			int valeur = 0 + r.nextInt(nbJoueur+1 - 0);
			System.out.println(valeur);
			tabTerritoire[i] = new Territoire(values[5], values[0], values[6], values[1], valeur, values[3], values[4], values[2]);
			System.out.println("tab id "+i+" "+values[0]+values[1]);
			i++;
		}
		fichier.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getNbTerritoireJoueur(int idJoueur) {
		int j = 0;
		for (int i = 0; i <= 41; i++) {
			if(tabTerritoire[i].getIdJoueur() == idJoueur) {
				j++;
			}
		}
		nbTerritoireJoueur = j;
		return nbTerritoireJoueur;
	}
	
	//affichage nom territoire graphiquement
	public static void AffichageTerritoireGraphique() {
		if(StdDraw.mousePressed()){
			Double xx=StdDraw.mouseX();
			Double yy=StdDraw.mouseY();
				
			try {
				String ligne ;
				BufferedReader fichier = new BufferedReader(new FileReader("./src/Territoire.txt"));
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
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//affichage map d'un joueur
	public void AffichageMapJoueur(int idJoueur) {
		StdDraw.picture(8.5, 9, "./src/images/RISK_image_blanche.png", 14.75, 9.75);
		StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
		for (int i = 0; i <= 41; i++) {
			if(tabTerritoire[i].getIdJoueur() == idJoueur) {
				int x = Integer.parseInt(tabTerritoire[i].getPosition_x());
				int y = Integer.parseInt(tabTerritoire[i].getPosition_y());
				Color couleur = null;
				switch(tabTerritoire[i].getCouleur()) {
					case "RED" :
						couleur = StdDraw.RED;
						break;
					case "YELLOW" :
						couleur = StdDraw.CYAN;
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
		}

	}
	
}
