import java.io.BufferedReader;
import java.io.FileReader;

import edu.princeton.cs.introcs.StdDraw;

public class Canon extends Unite{
	
	int cout = 3;
	int puissance = 2;
	int prioriteATT = 1;
	int prioriteDEF = 3;
	int mvtParTour = 3;
	String source = "./src/Territoire.txt";
	
	public Canon(int nombreUnites) {
		super(nombreUnites);
	}
	
	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getPrioriteATT() {
		return prioriteATT;
	}

	public void setPrioriteATT(int prioriteATT) {
		this.prioriteATT = prioriteATT;
	}

	public int getPrioriteDEF() {
		return prioriteDEF;
	}

	public void setPrioriteDEF(int prioriteDEF) {
		this.prioriteDEF = prioriteDEF;
	}

	public int getMvtParTour() {
		return mvtParTour;
	}

	public void setMvtParTour(int mvtParTour) {
		this.mvtParTour = mvtParTour;
	}
	
	public void affichagePion(int idJoueur) {
		int i = 0;
		while(i <= 1) {
			if(StdDraw.mousePressed()){
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				try {
					String ligne ;
					BufferedReader fichier = new BufferedReader(new FileReader(source));
					while ((ligne = fichier.readLine()) != null) {
						String values[]= ligne.split(" ");
						int x = Integer.parseInt(values[3]);
						int y = Integer.parseInt(values[4]);
						if ((x-0.5) <= xx && xx <= (x+0.5) && (y-0.25) <= yy && yy <= (y+0.25)) {
							StdDraw.picture(xx, yy, "./src/images/RISK_canon_jeton"+idJoueur+".png", 0.5, 0.75);
							i++;
						}
					}
					fichier.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
