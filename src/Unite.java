import javax.print.attribute.standard.Finishings;
import javax.swing.JOptionPane;
import javax.xml.crypto.dsig.CanonicalizationMethod;

import edu.princeton.cs.introcs.StdDraw;

public class Unite {
	
	Unite [] tabUnite;
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
	
	public void affihageNbUnite() {
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledSquare(0.5, 15, 0.5);
		StdDraw.filledSquare(1, 15, 0.5);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.textLeft(0.5, 15, "Unité : "+this.getNombre());
	}
	
	public void positionnerPion(int joueurId) {
		int j = 0;
		while(getNombre() > 0 && j < 1) {
			if(StdDraw.mousePressed()){
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				if(StdDraw.mousePressed() && 7.5 <= xx && xx <= 8.5 && 2.25 <= yy && yy <= 3.25) {
					if(this.getNombre() >= Cavalier.getCout()) {
						StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon_selectionnee.png", 1, 1.5);
						StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
						StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
						Cavalier cavalier = new Cavalier(this.getNombre(), joueurId, xx, yy);
						this.setNombre(nombre-Cavalier.getCout());
						Map.AffichageTerritoireGraphique(); 
						this.affihageNbUnite();
					}else {
						JOptionPane.showMessageDialog(null, "Vous n'avez que "+this.getNombre()+" unités !\nUn cavalier en coute "+Cavalier.getCout()+".","Info",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(StdDraw.mousePressed() && 1.5 <= xx && xx <= 2.5 && 2.25 <= yy && yy <= 3.25) {
					if(this.getNombre() >= Soldat.getCout()) {
						StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
						StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon_selectionnee.png", 1, 1.5);
						StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
						Soldat soldat = new Soldat(this.getNombre(), joueurId, xx, yy);
						this.setNombre(nombre-Soldat.getCout());
						Map.AffichageTerritoireGraphique();
						this.affihageNbUnite();
					}else {
						JOptionPane.showMessageDialog(null, "Vous n'avez que "+this.getNombre()+" unités !\nUn soldat en coute "+Soldat.getCout()+".","Info",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(StdDraw.mousePressed() && 4.25 <= xx && xx <= 5.75 && 2.25 <= yy && yy <= 3.25) {
					if(this.getNombre() >= Canon.getCout()) {
						StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
						StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
						StdDraw.picture(5, 3, "./src/images/RISK_canon_icon_selectionnee.png", 1.5, 2);
						Canon canon = new Canon(this.getNombre(), joueurId, xx, yy);
						this.setNombre(nombre-Canon.getCout());
						Map.AffichageTerritoireGraphique();
						this.affihageNbUnite();
					}else {
						JOptionPane.showMessageDialog(null, "Vous n'avez que "+this.getNombre()+" unités !\nUn canon en coute "+Canon.getCout()+".","Info",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(StdDraw.mousePressed() && 13.5 <= xx && xx <= 16.5 && 2.25 <= yy && yy <= 3.25) {
					System.out.println("Fin tour");
					j++;
				}
				
				StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
				StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
				StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
			}
		}
	}
}
