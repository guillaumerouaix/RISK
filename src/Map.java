import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Map {
	
	Territoire [] tabTerritoire  = new Territoire[42];
	ArrayList<Territoire> territoireListe = new ArrayList();

	public Map(int nbJoueur) {
		
		creationTerritoires(nbJoueur);
                attributionTerritoire(nbJoueur);
		
	}
	
	
	
	
//cr�ation des territoires 
	
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
			int idRegion = Integer.parseInt(values[0]);
			int idTerritoire = Integer.parseInt(values[1]);
			int idJoueurAleatoire = 0 + r.nextInt(nbJoueur+1 - 0);
			tabTerritoire[i] = new Territoire(values[5], idRegion, values[6], idTerritoire, idJoueurAleatoire, x, y, values[2]);
			i++;
		}
		fichier.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void attributionTerritoire(int nbJoueur) {
		ArrayList<Territoire> listeTemp = this.territoireListe;
                Random rand = new Random();
                int nbTerJoueur = listeTemp.size()/nbJoueur;
		for(int i = 0; i < nbJoueur; i++) {
			for(int j=0; j < nbTerJoueur; j ++){
                            int nombreAleatoire = rand.nextInt(listeTemp.size() - 0 + 1) + 0;
                            listeTemp.get(nombreAleatoire).setIdJoueur(i);
                            listeTemp.remove(nombreAleatoire);
                        }
		}
		
	}
	
	
	public void listageTerritoire() {
		try {
			String ligne;
			BufferedReader fichier = new BufferedReader(new FileReader("./src/Territoire.txt"));
		while ((ligne = fichier.readLine()) != null) {
			String values[]= ligne.split(" ");
			int x = Integer.parseInt(values[3]);
			int y = Integer.parseInt(values[4]);
			int idRegion = Integer.parseInt(values[0]);
			int idTerritoire = Integer.parseInt(values[1]);
			territoireListe.add(new Territoire(values[5], idRegion, values[6], idTerritoire, 0, x, y, values[2]));
		}
		fichier.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//r�cuperation du nb de territoires poss�dant un joueur
	
	public int getNbTerritoireJoueur(int idJoueur) {
		int nbTerritoireJoueur = 0;
		for (int i = 0; i <= 41; i++) {
			if(tabTerritoire[i].getIdJoueur() == idJoueur) {
				nbTerritoireJoueur++;
			}
		}
		return nbTerritoireJoueur;
	}
	
	
	
	
//r�cuperation nom regions poss�dant un joueur
	
	public String getNomsRegionJoueur(int idJoueur) {
		String nomsRegionJoueur = "";
		int A = 0;	int B = 0;	int C = 0;	int D = 0;	int E = 0;	int F = 0;
		for (int i = 0; i <= 41; i++) {
			if(tabTerritoire[i].getIdRegion() == 1 && tabTerritoire[i].getIdJoueur() == idJoueur) {
				A++;
				if (A >= 4) {
					nomsRegionJoueur = tabTerritoire[i].getNomRegion()+" "+nomsRegionJoueur;
				}
			}
			if(tabTerritoire[i].getIdRegion() == 2 && tabTerritoire[i].getIdJoueur() == idJoueur) {
				B++;
				if (B >= 9) {
					nomsRegionJoueur = tabTerritoire[i].getNomRegion()+" "+nomsRegionJoueur;
				}
			}
			if(tabTerritoire[i].getIdRegion() == 3 && tabTerritoire[i].getIdJoueur() == idJoueur) {
				C++;
				if (C >= 6) {
					nomsRegionJoueur = tabTerritoire[i].getNomRegion()+" "+nomsRegionJoueur;
				}
			}
			if(tabTerritoire[i].getIdRegion() == 4 && tabTerritoire[i].getIdJoueur() == idJoueur) {
				D++;
				if (D >= 7) {
					nomsRegionJoueur = tabTerritoire[i].getNomRegion()+" "+nomsRegionJoueur;
				}
			}
			if(tabTerritoire[i].getIdRegion() == 5 && tabTerritoire[i].getIdJoueur() == idJoueur) {
				E++;
				if (E >= 12) {
					nomsRegionJoueur = tabTerritoire[i].getNomRegion()+" "+nomsRegionJoueur;
				}
			}
			if(tabTerritoire[i].getIdRegion() == 6 && tabTerritoire[i].getIdJoueur() == idJoueur) {
				F++;
				if (F >= 4) {
					nomsRegionJoueur = tabTerritoire[i].getNomRegion()+" "+nomsRegionJoueur;
				}
			}
		}
		return nomsRegionJoueur;
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
		if(StdDraw.isMousePressed()){
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
	
	
	
	
//recuperation du nb de territoires dans une region
	
	public int NbTerritoiresDansRegion(String nomRegion) {
		int nbTerritoires = 0;
		for (int i = 0; i <= 41; i++) {
			if(tabTerritoire[i].getNomRegion() == nomRegion) {
				nbTerritoires++;
			}
		}
		return nbTerritoires;
	}
	
	
	
	
}
