import java.util.Timer;

public class RISK {

	public static void main(String[] args) {
		
		//affichage image couverture
		ImageLoader imageLoader = new ImageLoader("/images/RISK_couverture.jpg", 1200, 800);
		
		//attendre avant lancer jeu
		try {
			java.lang.Thread. sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//affichage map
		Map m = new Map();
		
	}

}
