import java.io.BufferedReader;
import java.io.FileReader;

import edu.princeton.cs.introcs.StdDraw;

public class Jeu {
	
	public Jeu() {
		
		Menu menu = new Menu();
		
		Map map = new Map();
		
		//test affichage pions sur map
		Cavalier cavalier = new Cavalier(1);
		Soldat soldat = new Soldat(1);
		Canon canon = new Canon(1);
		int j = 0;
		while(j == 0) {
			if(StdDraw.mousePressed()){
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				
				if(7.5 <= xx && xx <= 8.5 && 2.25 <= yy && yy <= 3.25) {
					StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon_selectionnee.png", 1, 1.5);
					StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
					StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
					cavalier.affichagePion();
					map.AffichageTerritoireGraphique();
				}
				
				try {
					java.lang.Thread. sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(1.5 <= xx && xx <= 2.5 && 2.25 <= yy && yy <= 3.25) {
					StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
					StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon_selectionnee.png", 1, 1.5);
					StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
					soldat.affichagePion();
					map.AffichageTerritoireGraphique();
				}
				
				try {
					java.lang.Thread. sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(4.25 <= xx && xx <= 5.75 && 2.25 <= yy && yy <= 3.25) {
					StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
					StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
					StdDraw.picture(5, 3, "./src/images/RISK_canon_icon_selectionnee.png", 1.5, 2);
					canon.affichagePion();
					map.AffichageTerritoireGraphique();
				}
				
				try {
					java.lang.Thread. sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
				StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
				StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
			}
		}
		
	}
}
