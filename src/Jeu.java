
import javax.swing.JOptionPane;

import edu.princeton.cs.introcs.StdDraw;

public class Jeu {
	
	int nbJoueur;
	Joueur[] tabJoueur;
	Unite[] tabUnite;
	Map map;
	
	public Jeu() {
		
		MenuInititialisationPartie();
		
		MapInitialisation();
		
		for(int e = 0; e <= 3; e++ ) {
			TourDeJeu();
		}
		
	}
	
	
	
	
//affichage page mun, initialisation de la partie
	
	public void MenuInititialisationPartie() {
		Menu menu = new Menu();
		nbJoueur = menu.SelectionNbJoueur();
		tabJoueur = new Joueur[nbJoueur+1];
		tabUnite = new Unite[nbJoueur+1];
		int[] armeeInit = {40, 40, 35, 30, 25, 20};
		for(int i = 0; i <= nbJoueur; i++) {
			tabJoueur[i] = new Joueur(i);
			tabUnite[i] = new Unite(armeeInit[nbJoueur],tabJoueur[i].getId());
		}
	}
	
	
	
	
//mise à blanc de la fenêtre, affichage du logo et icon
	
	public void MapInitialisation() {
		StdDraw.clear();
		StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
		StdDraw.picture(9, 16, "./src/images/RISK_logo.jpg", 5, 2);
		StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
		StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
		StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
		StdDraw.picture(15, 3, "./src/images/RISK_boutton_fin_tour.png", 3, 1.5);
		map = new Map(nbJoueur);
		map.AffichageMap();
	}
	
	
	
	
//lancement 1 tour de jeu par joueur
		
	public void TourDeJeu() {
		for(int i = 0; i <= nbJoueur; i++ ) {
			int j = i+1;
			AffichageIdJoueur(j);
			AffihageNbUniteJoueur(j);
			JOptionPane.showMessageDialog(null, "Joueur "+j+" à toi de jouer ! \n Il te reste "+tabUnite[i].getNombre()+" unités.","Info",JOptionPane.INFORMATION_MESSAGE);
			map.AffichageMapJoueur(i);
			tabUnite[i].positionnerPion(tabJoueur[i].getId());
			System.out.println(tabUnite[i].getId()+" "+tabUnite[i].getNombre());
		}
	}
	
	
	
	
//affichage du numero du joueur qui doit jouer
			
	public void AffichageIdJoueur(int idJoueur) {
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledSquare(0.5, 16, 0.5);
		StdDraw.filledSquare(1, 16, 0.5);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.textLeft(0.5, 16, "Joueur "+idJoueur);
	}
	
	
	

//affichage solde d'unites du joueur 	
	
	public void AffihageNbUniteJoueur(int idJoueur) {
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledSquare(0.5, 15, 0.5);
		StdDraw.filledSquare(1, 15, 0.5);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.textLeft(0.5, 15, "Unité : "+tabUnite[idJoueur].getNombre());
	}
	
	
	
	
}
