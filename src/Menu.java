import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;

import edu.princeton.cs.introcs.StdDraw;

public class Menu {
	
	public Menu() {
		StdDraw.setCanvasSize(1200, 800);
		StdDraw.setScale(0, 18);
		StdDraw.picture(9, 9, "./src/images/RISK_couverture.jpg", 18, 18);
		try {
			java.lang.Thread. sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StdDraw.clear();
		StdDraw.picture(9, 16, "./src/images/RISK_logo.jpg", 5, 2);
		StdDraw.picture(8.75, 8.5, "./src/images/RISK_menu.png", 15.5, 13);
		StdDraw.picture(4, 9, "./src/images/RISK_boutton1.png", 1.25, 2);
		StdDraw.picture(6, 9, "./src/images/RISK_boutton2.png", 1.25, 2);
		StdDraw.picture(8, 9, "./src/images/RISK_boutton3.png", 1.25, 2);
		StdDraw.picture(10, 9, "./src/images/RISK_boutton4.png", 1.25, 2);
		StdDraw.picture(12, 9, "./src/images/RISK_boutton5.png", 1.25, 2);
		StdDraw.picture(14, 9, "./src/images/RISK_boutton6.png", 1.25, 2);
		StdDraw.picture(9, 3, "./src/images/RISK_boutton_jouer.png", 4, 2);
		
		int i=0;
		while (i <= 100000) {
			if(StdDraw.mousePressed()){
				Double xx=StdDraw.mouseX();
				Double yy=StdDraw.mouseY();
				
				if(7 <= xx && xx <= 11 && 2 <= yy && yy <= 4) {
					Map map = new Map();
					i++;
				}
			}
		}
		StdDraw.clear();
	}
}
