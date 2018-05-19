import javax.print.attribute.standard.Finishings;

import edu.princeton.cs.introcs.StdDraw;

public class Unite {
	
	int nombre;
	int id;
	
	public Unite(int nombreUnites, int idJoueur) {
		nombre = nombreUnites;
		id = idJoueur;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public void positionnerPion(int joueurId) {
		int j = 0;
		while(getNombre() > 0 && j < 1) {
			if(StdDraw.mousePressed()){
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				if(7.5 <= xx && xx <= 8.5 && 2.25 <= yy && yy <= 3.25) {
					StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon_selectionnee.png", 1, 1.5);
					StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
					StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
					Cavalier cavalier = new Cavalier(this.getNombre(), joueurId);
					this.setNombre(nombre-Cavalier.getCout());
					cavalier.affichagePion(joueurId);
					Map.AffichageTerritoireGraphique();
				}
				
				if(1.5 <= xx && xx <= 2.5 && 2.25 <= yy && yy <= 3.25) {
					StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
					StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon_selectionnee.png", 1, 1.5);
					StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
					Soldat soldat = new Soldat(this.getNombre(), joueurId);
					this.setNombre(nombre-Soldat.getCout());
					Map.AffichageTerritoireGraphique();
				}
				
				if(4.25 <= xx && xx <= 5.75 && 2.25 <= yy && yy <= 3.25) {
					StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
					StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
					StdDraw.picture(5, 3, "./src/images/RISK_canon_icon_selectionnee.png", 1.5, 2);
					Canon canon = new Canon(this.getNombre(), joueurId);
					this.setNombre(nombre-Canon.getCout());
					Map.AffichageTerritoireGraphique();
				}
				
				if(13.5 <= xx && xx <= 16.5 && 2.25 <= yy && yy <= 3.25) {
					System.out.println("Fin tour");
					j++;
				}
				
				StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
				StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
				StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
				System.out.println(this.getNombre());
			}
		}
	}
}
