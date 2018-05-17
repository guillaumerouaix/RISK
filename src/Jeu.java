
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
			cavalier.affichagePion();
			map.AffichageTerritoireGraphique();
			try {
				java.lang.Thread. sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			soldat.affichagePion();
			map.AffichageTerritoireGraphique();
			try {
				java.lang.Thread. sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			canon.affichagePion();
			map.AffichageTerritoireGraphique();
			try {
				java.lang.Thread. sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
