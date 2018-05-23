import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Map {
	
	Territoire [] tabTerritoire  = new Territoire[42];

	public Map(int nbJoueur) {
		
		creationTerritoires(nbJoueur);
		
	}
	
	
	
	
//création des territoires 
	
	public void creationTerritoires(int nbJoueur) {
		Random r = new Random();
		int i = 0;
		try {
			String ligne;
			BufferedReader fichier = new BufferedReader(new FileReader("./src/Territoire.txt"));
		while ((ligne = fichier.readLine()) != null) {
			String values[]= ligne.split(" ");
			int x = Integer.parseInt(values[3]);
			int y = Integer.parseInt(values[4]);
			int idJoueurAleatoire = 0 + r.nextInt(nbJoueur+1 - 0);
			tabTerritoire[i] = new Territoire(values[5], values[0], values[6], values[1], idJoueurAleatoire, x, y, values[2]);
			i++;
		}
		fichier.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
//récuperation du nb de territoires possédant un joueur
	
	public int getNbTerritoireJoueur(int idJoueur) {
		int nbTerritoireJoueur = 0;
		for (int i = 0; i <= 41; i++) {
			if(tabTerritoire[i].getIdJoueur() == idJoueur) {
				nbTerritoireJoueur++;
			}
		}
		return nbTerritoireJoueur;
	}
	
	
	
	
//récuperation du nb de regions possédant un joueur
	
	public int getNbRegionJoueur(int idJoueur) {
		int nbRegionJoueur = 0;
		for (int i = 0; i <= 41; i++) {
			if(tabTerritoire[i]. getNomRegion() =) {
			if(tabTerritoire[i].getIdJoueur() == idJoueur) {
				nbRegionJoueur++;
			}
		}
		return nbRegionJoueur;
	}
		

	
	
//affichage map graphiquement
	
	public void AffichageMap() {
		StdDraw.picture(8.5, 9, "./src/images/RISK_image_blanche.png", 14.75, 9.75);
		StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
		for (int i = 0; i <= 41; i++) {
			int x = tabTerritoire[i].getPosition_x();
			int y = tabTerritoire[i].getPosition_y();
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
		
		
		
		
//affichage map d'un joueur graphiquement
	
	public void AffichageMapJoueur(int idJoueur) {
		for (int i = 0; i <= 41; i++) {
			if(tabTerritoire[i].getIdJoueur() == idJoueur) {
				int x = tabTerritoire[i].getPosition_x();
				int y = tabTerritoire[i].getPosition_y();
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
	
	
	
	
//affichage nom territoire graphiquement
		
	public void AffichageNomTerritoire() {
		if(StdDraw.mousePressed()){
			Double xx=StdDraw.mouseX();
			Double yy=StdDraw.mouseY();
			for (int i = 0; i <= 41; i++) {
				int x = tabTerritoire[i].getPosition_x();
				int y = tabTerritoire[i].getPosition_y();
				if ((x-0.5) <= xx && xx <= (x+0.5) && (y-0.25) <= yy && yy <= (y+0.25)) {
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledSquare(1, 1, 1);
					StdDraw.filledSquare(3, 1, 1);
					StdDraw.filledSquare(5, 1, 1);
					StdDraw.filledSquare(7, 1, 1);
					StdDraw.filledSquare(9, 1, 1);
					StdDraw.setPenColor(StdDraw.GRAY);
					
					StdDraw.textLeft(0.5, 1, tabTerritoire[i].getNomRegion()+"  /  "+tabTerritoire[i].getNom());
				}
			}
		}
	}
	
	
	
	
}
