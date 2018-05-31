import java.util.Random;

public class Mission {
	
	int idJoueur;
	int Mission;
	int idJoueurDetruire;
	
	public Mission(int idjoueur, int idmission) {
		idJoueur = idjoueur;
		Mission = idmission;
		int joueur = 0;
		while(joueur == idjoueur) {
			Random r = new Random();
			joueur =  1 + r.nextInt(8+1 - 1);
			idJoueurDetruire = joueur;
		}
	}
	
	public int getIdJoueur() {
		return idJoueur;
	}

	public int getMission() {
		return Mission;
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
			butMission = "Contr�ler la plus grosse r�gion �tant l'Asie et 1 autre r�gion.";
			break;
	}
		return butMission;
	}

	public  boolean VerifMission() {
		switch(this.getMission()) {
			case 1 :
				return this.detruireLeJoueurX();
				break;
			case 2 :
				return this.conquerirTousLesTerritoires();
				break;
			case 3 :
				return this.controler3RegionsEtAuMoins18Territoires();
				break;
			case 4 :
				return this.controler18TerritoiresAvecAuMoins2Armees();
				break;
			case 5 :
				return this.controler30Territoires();
				break;
			case 6 :
				return this.controler24Territoires();
				break;
			case 7 :
				return this.controler21Territoires();
				break;
			case 8 :
				return this.controlerLaPlusGrosseRegionEt1AutreRegion();
				break;
		}
		return false;
	}
	
	public boolean detruireLeJoueurX() {
		return false;
	}
	
	public boolean conquerirTousLesTerritoires() {
		if(map.getNbTerritoireJoueur(this.getIdJoueur()) >= 42) {
			return true;
		}
		return false;
	}
	
	public boolean controler3RegionsEtAuMoins18Territoires() {
		String values[] = map.getNomsRegionJoueur(this.getIdJoueur()).split(" ");
		int nbRegion = values.length;
		if(map.getNbTerritoireJoueur(this.getIdJoueur()) >= 18 && nbRegion >= 3) {
			return true;
		}
		return false;
	}
	
	public boolean controler18TerritoiresAvecAuMoins2Armees() {
		return false;
	}
	
	public boolean controler30Territoires() {
		if(map.getNbTerritoireJoueur(this.getIdJoueur()) >= 30) {
			return true;
		}
		return false;
	}

	public boolean controler24Territoires() {
		if(map.getNbTerritoireJoueur(this.getIdJoueur()) >= 24) {
			return true;
		}
		return false;
	}
	
	public boolean controler21Territoires() {
		if(map.getNbTerritoireJoueur(this.getIdJoueur()) >= 21) {
			return true;
		}
		return false;
	}
	
	public boolean controlerLaPlusGrosseRegionEt1AutreRegion() {
		String values[] = map.getNomsRegionJoueur(this.getIdJoueur()).split(" ");
		int nbRegion = values.length;
		for(int i; i < nbRegion; i++) {
			if(nbRegion >= 2 && values[i] == "ASIE") {
				return true;
			}
		}
		return false;
	}
	
}
