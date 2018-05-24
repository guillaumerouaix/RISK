import java.util.Random;

public class Mission {
	
	int idJoueur;
	int Mission;
	int idJoueurDetruire;
	
	public Mission(int idjoueur, int idmission) {
		idJoueur = idjoueur;
		Mission = idmission;
		int joueur = 0;
		while(joueur != idjoueur) {
			Random r = new Random();
			joueur =  1 + r.nextInt(8+1 - 1);
			idJoueurDetruire = joueur;
		}
	}
	
	public String getMission(int idmission) {
		String butMission = "";
		int joueurDetruire = idJoueurDetruire+1;
		switch(idmission) {
		case 1 :
			butMission = "Détruire le joueur "+joueurDetruire+".";
			break;
		case 2 :
			butMission = "Conquérir tous les territoires.";
			break;
		case 3 :
			butMission = "Contrôler 3 régions et au moins 18 territoires.";
			break;
		case 4 :
			butMission = "Contrôler 18 territoires avec au moins 2 armées.";
			break;
		case 5 :
			butMission = "Contrôler 30 territoires.";
			break;
		case 6 :
			butMission = "Contrôler 24 territoires.";
			break;
		case 7 :
			butMission = "Contrôler 21 territoires.";
			break;
		case 8 :
			butMission = "Contrôler la plus grosse région et 1 autre région.";
			break;
	}
		return butMission;
	}

	public  String VerifMission(int idJoueur, int idMission, int idJoueurDetruire) {
		Random r = new Random();
		switch( 1 + r.nextInt(8+1 - 1)) {
			case 1 :
//				return "DétruireLeJoueurX";
				break;
			case 2 :
//				return "ConquérirTousLesTerritoires";
				break;
			case 3 :
//				return "Contrôler3RégionsEtAuMoins18Territoires";
				break;
			case 4 :
//				return "Contrôler18TerritoiresAvecAuMoins2Armées";
				break;
			case 5 :
//				return "Contrôler30Territoires";
				break;
			case 6 :
//				return "Contrôler24Territoires";
				break;
			case 7 :
//				return "Contrôler21Territoires";
				break;
			case 8 :
//				return "ContrôlerLaPlusGrosseRégionEt1AutreRégion";
				break;
		}
		return null;
	}
	
	public void DétruireLeJoueurX() {
	
	}
	
	public void ConquérirTousLesTerritoires() {
		
	}
	
	public void Contrôler3RégionsEtAuMoins18Territoires() {
		
	}
	
	public void Contrôler18TerritoiresAvecAuMoins2Armées() {
		
	}
	
	public void Contrôler30Territoires() {
		
	}

	public void Contrôler24Territoires() {
		
	}
	
	public void Contrôler21Territoires() {
		
	}
	
	public void ContrôlerLaPlusGrosseRégionEt1AutreRégion() {
		
	}
	
}
