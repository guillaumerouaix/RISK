
import edu.princeton.cs.introcs.StdDraw;

public class Menu {
	
	public Menu() {
		
		//cr�ation fen�tre
		StdDraw.setCanvasSize(1900, 950);
		StdDraw.setScale(0, 18);
		
		//affichage couverture jeu
		StdDraw.picture(9, 9, "./src/images/RISK_couverture.jpg", 18, 18);
		
		//pause dans le code pour affichage couverture jeu
		try {
			java.lang.Thread. sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//mise � blanc de la fen�tre
		StdDraw.clear();
		
		//affichage graphique du menu
		StdDraw.picture(9, 16, "./src/images/RISK_logo.jpg", 5, 2);
		StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
		StdDraw.picture(4, 9, "./src/images/RISK_boutton1.png", 1.25, 2);
		StdDraw.picture(6, 9, "./src/images/RISK_boutton2.png", 1.25, 2);
		StdDraw.picture(8, 9, "./src/images/RISK_boutton3.png", 1.25, 2);
		StdDraw.picture(10, 9, "./src/images/RISK_boutton4.png", 1.25, 2);
		StdDraw.picture(12, 9, "./src/images/RISK_boutton5.png", 1.25, 2);
		StdDraw.picture(14, 9, "./src/images/RISK_boutton6.png", 1.25, 2);
		StdDraw.picture(9, 3, "./src/images/RISK_message_menu.png", 11, 2);
	}
		
	
	
	
//r�cup�ration de la selection du nombre de joueurs
	
	public int SelectionNbJoueur() {
		int i=0;
		while (i <= 1) {
			if(StdDraw.isMousePressed()){
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				
				if(3.37 <= xx && xx <= 4.63 && 8 <= yy && yy <= 10) {
					i++;
					return 1;
				}
				
				if(5.37 <= xx && xx <= 6.63 && 8 <= yy && yy <= 10) {
					i++;
					return 1;
				}
				
				if(7.37 <= xx && xx <= 8.63 && 8 <= yy && yy <= 10) {
					i++;
					return 2;
				}
				
				if(9.37 <= xx && xx <= 10.63 && 8 <= yy && yy <= 10) {
					i++;
					return 3;
				}
				
				if(11.37 <= xx && xx <= 12.63 && 8 <= yy && yy <= 10) {
					i++;
					return 4;
				}
				
				if(13.37 <= xx && xx <= 14.63 && 8 <= yy && yy <= 10) {
					i++;
					return 5;
				}
			}
		}
		return 0;
		
	}
	
	
	
	
}
