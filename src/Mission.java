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
			butMission = "D�truire le joueur "+joueurDetruire+".";
			break;
		case 2 :
			butMission = "Conqu�rir tous les territoires.";
			break;
		case 3 :
			butMission = "Contr�ler 3 r�gions et au moins 18 territoires.";
			break;
		case 4 :
			butMission = "Contr�ler 18 territoires avec au moins 2 arm�es.";
			break;
		case 5 :
			butMission = "Contr�ler 30 territoires.";
			break;
		case 6 :
			butMission = "Contr�ler 24 territoires.";
			break;
		case 7 :
			butMission = "Contr�ler 21 territoires.";
			break;
		case 8 :
			butMission = "Contr�ler la plus grosse r�gion et 1 autre r�gion.";
			break;
	}
		return butMission;
	}

	public  String VerifMission(int idJoueur, int idMission, int idJoueurDetruire) {
		Random r = new Random();
		switch( 1 + r.nextInt(8+1 - 1)) {
			case 1 :
//				return "D�truireLeJoueurX";
				break;
			case 2 :
//				return "Conqu�rirTousLesTerritoires";
				break;
			case 3 :
//				return "Contr�ler3R�gionsEtAuMoins18Territoires";
				break;
			case 4 :
//				return "Contr�ler18TerritoiresAvecAuMoins2Arm�es";
				break;
			case 5 :
//				return "Contr�ler30Territoires";
				break;
			case 6 :
//				return "Contr�ler24Territoires";
				break;
			case 7 :
//				return "Contr�ler21Territoires";
				break;
			case 8 :
//				return "Contr�lerLaPlusGrosseR�gionEt1AutreR�gion";
				break;
		}
		return null;
	}
	
	public void D�truireLeJoueurX() {
	
	}
	
	public void Conqu�rirTousLesTerritoires() {
		
	}
	
	public void Contr�ler3R�gionsEtAuMoins18Territoires() {
		
	}
	
	public void Contr�ler18TerritoiresAvecAuMoins2Arm�es() {
		
	}
	
	public void Contr�ler30Territoires() {
		
	}

	public void Contr�ler24Territoires() {
		
	}
	
	public void Contr�ler21Territoires() {
		
	}
	
	public void Contr�lerLaPlusGrosseR�gionEt1AutreR�gion() {
		
	}
	
}
