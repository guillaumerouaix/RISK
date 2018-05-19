
import javax.swing.JOptionPane;

import edu.princeton.cs.introcs.StdDraw;

public class Jeu {
	
	public Jeu() {
		
		Menu menu = new Menu();
		int nbJoueur = menu.SelectionNbJoueur();
		Joueur[] tabJoueur = new Joueur[nbJoueur+1];
		Unite[] tabUnite = new Unite[nbJoueur+1];
		int[] armeeInit = {40, 40, 35, 30, 25, 20};
		for(int i = 0; i <= nbJoueur; i++) {
			tabJoueur[i] = new Joueur(i);
			tabUnite[i] = new Unite(armeeInit[nbJoueur],tabJoueur[i].getId());
		}
		
		Map map = new Map();
		for(int e = 0; e <= 3; e++ ) {
			for(int i = 0; i <= nbJoueur; i++ ) {
				int j = i+1;
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
				StdDraw.filledSquare(0.5, 16, 0.5);
				StdDraw.filledSquare(1, 16, 0.5);
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.textLeft(0.5, 16, "Joueur "+j);
				JOptionPane.showMessageDialog(null, "Joueur "+j+" à toi de jouer ! \n Il te reste "+tabUnite[i].getNombre()+" unités.","Info",JOptionPane.INFORMATION_MESSAGE);
				tabUnite[i].positionnerPion(tabJoueur[i].getId());
				System.out.println(tabUnite[i].getId()+" "+tabUnite[i].getNombre());
			}
		}
		
	}
}
