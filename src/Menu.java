
import edu.princeton.cs.introcs.StdDraw;

public class Menu {
	
	public Menu() {
		
		//création fenêtre
		StdDraw.setCanvasSize(1200, 800);
		StdDraw.setScale(0, 18);
		
		//affichage couverture jeu
		StdDraw.picture(9, 9, "./src/images/RISK_couverture.jpg", 18, 18);
		
		//pause dans le code pour affichage couverture jeu
		try {
			java.lang.Thread. sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//mise à blanc de la fenêtre
		StdDraw.clear();
		
		//affichage graphique du menu
		StdDraw.picture(9, 16, "./src/images/RISK_logo.jpg", 5, 2);
		StdDraw.picture(8.75, 8.5, "./src/images/RISK_menu.png", 15.5, 13);
		StdDraw.picture(4, 9, "./src/images/RISK_boutton1.png", 1.25, 2);
		StdDraw.picture(6, 9, "./src/images/RISK_boutton2.png", 1.25, 2);
		StdDraw.picture(8, 9, "./src/images/RISK_boutton3.png", 1.25, 2);
		StdDraw.picture(10, 9, "./src/images/RISK_boutton4.png", 1.25, 2);
		StdDraw.picture(12, 9, "./src/images/RISK_boutton5.png", 1.25, 2);
		StdDraw.picture(14, 9, "./src/images/RISK_boutton6.png", 1.25, 2);
		StdDraw.picture(9, 3, "./src/images/RISK_message_menu.png", 11, 2);
		
		//récupération de la selection du nombre de joueurs, création des joueurs et de la map
		int i=0;
		while (i <= 1) {
			if(StdDraw.mousePressed()){
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				
				if(3.37 <= xx && xx <= 4.63 && 8 <= yy && yy <= 10) {
					Joueur joueur1 = new Joueur(1);
					Joueur joueurIA = new Joueur(2);
					new Map();
					i++;
				}
				
				if(5.37 <= xx && xx <= 6.63 && 8 <= yy && yy <= 10) {
					Joueur joueur1 = new Joueur(1);
					Joueur joueur2 = new Joueur(2);
					new Map();
					i++;
				}
				
				if(7.37 <= xx && xx <= 8.63 && 8 <= yy && yy <= 10) {
					Joueur joueur1 = new Joueur(1);
					Joueur joueur2 = new Joueur(2);
					Joueur joueur3 = new Joueur(3);
					new Map();
					i++;
				}
				
				if(9.37 <= xx && xx <= 10.63 && 8 <= yy && yy <= 10) {
					Joueur joueur1 = new Joueur(1);
					Joueur joueur2 = new Joueur(2);
					Joueur joueur3 = new Joueur(3);
					Joueur joueur4 = new Joueur(4);
					new Map();
					i++;
				}
				
				if(11.37 <= xx && xx <= 12.63 && 8 <= yy && yy <= 10) {
					Joueur joueur1 = new Joueur(1);
					Joueur joueur2 = new Joueur(2);
					Joueur joueur3 = new Joueur(3);
					Joueur joueur4 = new Joueur(4);
					Joueur joueur5 = new Joueur(5);
					new Map();
					i++;
				}
				
				if(13.37 <= xx && xx <= 14.63 && 8 <= yy && yy <= 10) {
					Joueur joueur1 = new Joueur(1);
					Joueur joueur2 = new Joueur(2);
					Joueur joueur3 = new Joueur(3);
					Joueur joueur4 = new Joueur(4);
					Joueur joueur5 = new Joueur(5);
					Joueur joueur6 = new Joueur(6);
					new Map();
					i++;
				}
			}
		}
		
		//mise à blanc de la fenêtre
		StdDraw.clear();
		
	}
}
