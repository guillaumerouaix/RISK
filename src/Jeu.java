import java.util.ArrayList;

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
		
		for(int i = 0; i <= nbJoueur; i++ ) {
			System.out.println(tabUnite[i].getId());
			i++;
		}

		for(int i = 0; i <= nbJoueur; i++ ) {
			tabUnite[i].positionnerPion(tabJoueur[i].getId());
		}
		
	}
}
