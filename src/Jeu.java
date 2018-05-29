
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import edu.princeton.cs.introcs.StdDraw;

public class Jeu {
	
	int nbJoueur;
	Joueur[] tabJoueur;
	Unite[] tabUnite;
	Mission[] tabMission = new Mission[6];;
	ArrayList pionListe = new ArrayList();
	Map map;
	
	public Jeu() {
		
		menuInititialisationPartie();
		
		mapInitialisation();
		
		affectationMission();
		
		for(int e = 0; e <= 3; e++ ) {
			tourDeJeu();
		}
		
	}
	
	
	
	
//affichage page menu, initialisation de la partie
	
	public void menuInititialisationPartie() {
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
	
	
	
	
//mise � blanc de la fen�tre, affichage du logo, map et icon
	
	public void mapInitialisation() {
		StdDraw.clear();
		StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
		StdDraw.picture(9, 16, "./src/images/RISK_logo.jpg", 5, 2);
		StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
		StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
		StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
		StdDraw.picture(15, 3, "./src/images/RISK_boutton_fin_placement.png", 3, 1.5);
		map = new Map(nbJoueur);
		map.AffichageMap();
	}
	
	
	
	
//1 tour de jeu par joueur
		
	public void tourDeJeu() {
		for(int i = 0; i <= nbJoueur; i++ ) {
			int numeroJoueur = i+1;
			AffichageIdJoueur(numeroJoueur);
			AffihageSoldeUniteJoueur(i);
			StdDraw.picture(15, 3, "./src/images/RISK_boutton_fin_placement.png", 3, 1.5);
			JOptionPane.showMessageDialog(null, "Joueur "+numeroJoueur+" � toi de jouer ! \nIl te reste "+tabUnite[i].getNombre()+" unit�s.","Info",JOptionPane.INFORMATION_MESSAGE);
			StdDraw.picture(8.5, 9, "./src/images/RISK_image_blanche.png", 14.75, 9.75);
			StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
			map.AffichageMapJoueur(i);
			AffichagePions();
			placement(i);
			StdDraw.picture(15, 3, "./src/images/RISK_boutton_fin_attaque.png", 3, 1.5);
			JOptionPane.showMessageDialog(null, "Attaque des territoires !","Attaque",JOptionPane.INFORMATION_MESSAGE);
			attaque(i);
			ReceptionRenfort(i);
		}
	}
	
	
	
	
	public void placement(int idJoueur) {
		int j = 0;
		JOptionPane.showMessageDialog(null, "Place tes arm�es sur la map !","Placement",JOptionPane.INFORMATION_MESSAGE);
		while(tabUnite[idJoueur].getNombre() > 0 && j < 1) {
			map.AffichageNomTerritoire();
			String typeUnite = selectionTypeUnite(idJoueur);
			if(typeUnite != "" && typeUnite != "fin") {
				recupPosition(idJoueur, typeUnite, "placement");
				map.AffichageMapJoueur(idJoueur);
				AffichagePions();
				AffihageSoldeUniteJoueur(idJoueur);
				StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
				StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
				StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
			    for(int f = 0; f < pionListe.size(); f++)
			    {
			      System.out.println("ligne " + f + " : " + pionListe.get(f));
			    } 
			}
			if(typeUnite == "fin") {
				j++;
			}
		}
	}
	
	
	
	public void attaque(int idJoueur) {
		int j = 0;
		String fin = "";
		while(j < 1) {
			map.AffichageNomTerritoire();
			fin = deplacementPion(idJoueur);
			StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
			map.AffichageMapJoueur(idJoueur);
			AffichagePions();
			for(int f = 0; f < pionListe.size(); f++) {
				System.out.println("ligne " + f + " : " + pionListe.get(f));
			}
			if(fin == "fin") {
				j++;
			}
		}
	}
	
	
	
//rep�re le type d'unit� s�lectionn�e
	
	public String selectionTypeUnite(int idJoueur) {
		String typeUnite = "";
		if(StdDraw.isMousePressed()){
			Double xx=StdDraw.mouseX();
			Double yy=StdDraw.mouseY();
			if(7.5 <= xx && xx <= 8.5 && 2.25 <= yy && yy <= 3.25) {
				if(tabUnite[idJoueur].getNombre() >= Cavalier.getCout()) {
					StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon_selectionnee.png", 1, 1.5);
					StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
					StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
					typeUnite = "cavalier";
				}else {
					JOptionPane.showMessageDialog(null, "Vous n'avez que "+tabUnite[idJoueur].getNombre()+" unit�s !\nUn cavalier en coute "+Cavalier.getCout()+".","Info",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(1.5 <= xx && xx <= 2.5 && 2.25 <= yy && yy <= 3.25) {
				if(tabUnite[idJoueur].getNombre() >= Soldat.getCout()) {
					StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
					StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon_selectionnee.png", 1, 1.5);
					StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
					typeUnite = "soldat";
				}else {
					JOptionPane.showMessageDialog(null, "Vous n'avez que "+tabUnite[idJoueur].getNombre()+" unit�s !\nUn soldat en coute "+Soldat.getCout()+".","Info",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(4.25 <= xx && xx <= 5.75 && 2.25 <= yy && yy <= 3.25) {
				if(tabUnite[idJoueur].getNombre() >= Canon.getCout()) {
					StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
					StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
					StdDraw.picture(5, 3, "./src/images/RISK_canon_icon_selectionnee.png", 1.5, 2);
					typeUnite = "canon";
				}else {
					JOptionPane.showMessageDialog(null, "Vous n'avez que "+tabUnite[idJoueur].getNombre()+" unit�s !\nUn canon en coute "+Canon.getCout()+".","Info",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(13.5 <= xx && xx <= 16.5 && 2.25 <= yy && yy <= 3.25) {
				return "fin";
			}
		}
		return typeUnite;
	}
	
	
	
	
//d�placement d'un pion lors d'une attaque
	
	public String deplacementPion(int idJoueur) {
		String ligne;
		int j = 0;
		while(j < 1) {
			if(StdDraw.isMousePressed()){
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				for(int i = 0; i < pionListe.size(); i++) {
					ligne = (String) pionListe.get(i);
					String values[]= ligne.split(" ");
					int idJoueur2 = Integer.parseInt(values[0]);
					String typeUnite = values[1];
					int x = Integer.parseInt(values[2]);
					int y = Integer.parseInt(values[3]);
					if(x-0.32-0.15 <= xx && xx <= x-0.32+0.15 && y-0.2-0.25 <= yy && yy <= y-0.2+0.25) {
						if(idJoueur2 == idJoueur) {
							pionListe.remove(pionListe.get(i));
							JOptionPane.showMessageDialog(null, "Pion enleve","D�placement",JOptionPane.INFORMATION_MESSAGE);
							recupPosition(idJoueur, typeUnite, "attaque");
							j++;
						}
					}
					if(x+0.32-0.15 <= xx && xx <= x+0.32+0.15 && y-0.2-0.25 <= yy && yy <= y-0.2+0.25) {
						if(idJoueur2 == idJoueur) {
							pionListe.remove(pionListe.get(i));
							JOptionPane.showMessageDialog(null, "Pion enleve","D�placement",JOptionPane.INFORMATION_MESSAGE);
							recupPosition(idJoueur, typeUnite, "attaque");
							j++;
						}
					}
					if(x-0.15 <= xx && xx <= x+0.15 && y-0.2-0.25 <= yy && yy <= y-0.2+0.25) {
						if(idJoueur2 == idJoueur) {
							pionListe.remove(pionListe.get(i));
							JOptionPane.showMessageDialog(null, "Pion enleve","D�placement",JOptionPane.INFORMATION_MESSAGE);
							recupPosition(idJoueur, typeUnite, "attaque");
							j++;
						}
					}
					if(13.5 <= xx && xx <= 16.5 && 2.25 <= yy && yy <= 3.25) {
						j++;
						return "fin";
					}
				}
			}
		}
		return "";
	}
	
	
//creation d'un pion

	public void creationPion(int idJoueur, String typeUnite, int x, int y) {
		switch(typeUnite) {
			case "cavalier" :
				new Cavalier(tabUnite[idJoueur].getNombre(), idJoueur, x, y);
				pionListe.add(idJoueur+" "+typeUnite+" "+x+" "+y);
				tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()-Cavalier.getCout());
				break;
			case "soldat" :
				new Soldat(tabUnite[idJoueur].getNombre(), idJoueur, x, y);
				pionListe.add(idJoueur+" "+typeUnite+" "+x+" "+y);
				tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()-Soldat.getCout());
				break;
			case "canon" :
				new Canon(tabUnite[idJoueur].getNombre(), idJoueur, x, y);
				pionListe.add(idJoueur+" "+typeUnite+" "+x+" "+y);
				tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()-Canon.getCout());
				break;
		}
	}
	
	
	
	public void recupPosition(int idJoueur, String typeUnite, String typeCreation) {
		int i = 0;
		while(i < 1) {
			if(StdDraw.isMousePressed()){
				map.AffichageNomTerritoire();
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				for (int j = 0; j <= 41; j++) {
					int x = map.territoireListe.get(j).getPosition_x();
					int y = map.territoireListe.get(j).getPosition_y();
					if ((x-0.5) <= xx && xx <= (x+0.5) && (y-0.25) <= yy && yy <= (y+0.25) && map.territoireListe.get(j).getIdJoueur() == idJoueur && typeCreation == "placement") {
						 creationPion(idJoueur, typeUnite, x, y);
						i++;
					}
					if ((x-0.5) <= xx && xx <= (x+0.5) && (y-0.25) <= yy && yy <= (y+0.25) && map.territoireListe.get(j).getIdJoueur() != idJoueur && typeCreation == "attaque") {
						creationPion(idJoueur, typeUnite, x, y);
						i++;
					}
				}
			}
		}
	}
	
	
	
	
//creation d'un pion

//	public void CreationPion(int idJoueur, String typeUnite, String typecrea) {
//		int i = 0;
//		while(i < 1) {
//			if(StdDraw.isMousePressed()){
//				map.AffichageNomTerritoire();
//				Double xx=StdDraw.mouseX();
//				Double yy=StdDraw.mouseY();
//				for (int j = 0; j <= 41; j++) {
//					int x = map.tabTerritoire[j].getPosition_x();
//					int y = map.tabTerritoire[j].getPosition_y();
//					if ((x-0.5) <= xx && xx <= (x+0.5) && (y-0.25) <= yy && yy <= (y+0.25) && map.tabTerritoire[j].getIdJoueur() == idJoueur && typecrea == "placement") {
//						switch(typeUnite) {
//							case "cavalier" :
//								new Cavalier(tabUnite[idJoueur].getNombre(), idJoueur, xx, yy);
//								pionListe.add(idJoueur+" "+typeUnite+" "+x+" "+y);
//								System.out.println("cout "+Cavalier.getCout());
//								tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()-Cavalier.getCout());
//								break;
//							case "soldat" :
//								new Soldat(tabUnite[idJoueur].getNombre(), idJoueur, xx, yy);
//								pionListe.add(idJoueur+" "+typeUnite+" "+x+" "+y);
//								System.out.println("cout "+Soldat.getCout());
//								tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()-Soldat.getCout());
//								break;
//							case "canon" :
//								new Canon(tabUnite[idJoueur].getNombre(), idJoueur, xx, yy);
//								pionListe.add(idJoueur+" "+typeUnite+" "+x+" "+y);
//								System.out.println("cout "+Canon.getCout());
//								tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()-Canon.getCout());
//								break;
//						}
//						i++;
//					}
//					if ((x-0.5) <= xx && xx <= (x+0.5) && (y-0.25) <= yy && yy <= (y+0.25) && map.tabTerritoire[j].getIdJoueur() != idJoueur && typecrea == "attaque") {
//						switch(typeUnite) {
//							case "cavalier" :
//								new Cavalier(tabUnite[idJoueur].getNombre(), idJoueur, xx, yy);
//								pionListe.add(idJoueur+" "+typeUnite+" "+x+" "+y);
//								System.out.println("cout "+Cavalier.getCout());
//								tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()-Cavalier.getCout());
//								break;
//							case "soldat" :
//								new Soldat(tabUnite[idJoueur].getNombre(), idJoueur, xx, yy);
//								pionListe.add(idJoueur+" "+typeUnite+" "+x+" "+y);
//								System.out.println("cout "+Soldat.getCout());
//								tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()-Soldat.getCout());
//								break;
//							case "canon" :
//								new Canon(tabUnite[idJoueur].getNombre(), idJoueur, xx, yy);
//								pionListe.add(idJoueur+" "+typeUnite+" "+x+" "+y);
//								System.out.println("cout "+Canon.getCout());
//								tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()-Canon.getCout());
//								break;
//						}
//						i++;
//					}
//				}
//			}
//		}
//	}
	
	
	
	
//affichage des pions pr�sents sur la map
	
	public void AffichagePions() {
		String ligne;
		String ligne2;
		int k;
		StdDraw.setPenColor(StdDraw.BLACK);
		for(int i = 0; i < pionListe.size(); i++) {
			ligne = (String) pionListe.get(i);
			String values[]= ligne.split(" ");
			int idJoueur = Integer.parseInt(values[0]);
			String typePion = values[1];
			int x = Integer.parseInt(values[2]);
			int y = Integer.parseInt(values[3]);
			k = 0;
			for(int j = 0; j < pionListe.size(); j++) {
				ligne2 = (String) pionListe.get(j);
				String values2[]= ligne.split(" ");
				int idJoueur2 = Integer.parseInt(values2[0]);
				String typePion2 = values2[1];
				int x2 = Integer.parseInt(values2[2]);
				int y2 = Integer.parseInt(values2[3]);
				if(idJoueur == idJoueur2 && x == x2 && y == y2 ) {
					k++;
//					System.out.println("nb soldat "+k+" "+pionListe.size()+" "+ligne+" "+ligne2);
				}
			}
			switch(typePion) {
			case "cavalier" :
				if(k >= 1) {
					StdDraw.textLeft(x-0.38, y+0.20, ""+k);
				}
				StdDraw.picture(x-0.32, y-0.20, "./src/images/RISK_cavalier_jeton"+idJoueur+".png", 0.30, 0.5);
				break;
			case "soldat" :
				if(k >= 1) {
					StdDraw.textLeft(x+0.27, y+0.20, ""+k);
				}
				StdDraw.picture(x+0.32, y-0.20, "./src/images/RISK_soldat_jeton"+idJoueur+".png", 0.30, 0.5);
				break;
			case "canon" :
				if(k >= 1) {
					StdDraw.textLeft(x-0.05, y+0.20, ""+k);
				}
				StdDraw.picture(x, y-0.20, "./src/images/RISK_canon_jeton"+idJoueur+".png", 0.30, 0.5);
				break;
			}
		}
	}
	
	
	
	
//rajout d'unites a la fin d'un tour
	
	public void ReceptionRenfort(int idJoueur) {
		int renfort = 0;
		int nbTerritoires = map.getNbTerritoireJoueur(idJoueur);
		renfort = (int) Math.floor(nbTerritoires/3);
		System.out.println("nb renfort "+renfort);
		System.out.println("nb territoires "+nbTerritoires);
		String Regions = map.getNomsRegionJoueur(idJoueur);
		String values[]= Regions.split(" ");
		int nbRegions = values.length;
		System.out.println("nb regions "+nbRegions);
		if(Regions != "") {
				for(int i = 0; i < nbRegions; i++) {
					renfort = renfort + (int) Math.floor(map.NbTerritoiresDansRegion(values[i])/2);
				}
		}
		tabUnite[idJoueur].setNombre(tabUnite[idJoueur].getNombre()+renfort);
		System.out.println("Fin du tour du joueur "+idJoueur+", r�ception de "+renfort+" unit�s");
		
	}
	
	
	
	
//affectation des missions aux joueurs
	
	public void affectationMission() {
		int j = 0;
		for(int i = 0; i <= nbJoueur; i++ ) {
			Random r = new Random();
			int idMission =  1 + r.nextInt(8+1 - 1);
			System.out.println("a");
			tabMission[i] = new Mission(i, idMission);
			System.out.println("b");
			j = i+1;
			JOptionPane.showMessageDialog(null, "Attention ! \nJoueur "+j+", ta mission va �tre d�voil�e, seul toi dois la connaitre.","Mission",JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "Joueur "+j+", voici ta mission : \n"+tabMission[i].getMission(idMission),"Mission",JOptionPane.INFORMATION_MESSAGE);
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
	
	public void AffihageSoldeUniteJoueur(int idJoueur) {
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledSquare(0.5, 15, 0.5);
		StdDraw.filledSquare(1, 15, 0.5);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.textLeft(0.5, 15, "Unit� : "+tabUnite[idJoueur].getNombre());
	}
	
	
	
		
}
