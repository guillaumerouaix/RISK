import java.io.BufferedReader;
import java.io.FileReader;

import edu.princeton.cs.introcs.StdDraw;

public class Jeu {
	
	public Jeu() {
		
		Menu menu = new Menu();
		int nbJoueur = menu.SelectionNbJoueur();
		Joueur[] tabJoueur;
		tabJoueur = new Joueur[nbJoueur+1];
		for(int i = 0; i <= nbJoueur; i++) {
			tabJoueur[i] = new Joueur(i);
			System.out.println(tabJoueur[i].getId()+" "+i);
		}
		for(int i = 0; i <= nbJoueur; i++ ) {
			System.out.println(tabJoueur[i].getId()+" "+i);
		}
		Map map = new Map();
		
		Unite unite = new Unite(1);
		unite.positionnerPion(tabJoueur[0].getId());
	}
}
