
import java.util.Random;

public class Mission {

    private int idJoueur;
    private int idMission;
    private int idJoueurDetruire;
    private Map map;

    public Mission(int idjoueur) {
        idJoueur = idjoueur;
        Random r = new Random();
        idMission = 1 + r.nextInt(8 + 1 - 1);
        int joueur = 0;
        while (joueur == idjoueur) {
            Random r2 = new Random();
            joueur = 1 + r2.nextInt(8 + 1 - 1);
            idJoueurDetruire = joueur;
        }
    }

    public int getIdJoueurDetruire() {
        return idJoueurDetruire;
    }

    public void setIdJoueurDetruire(int idJoueurDetruire) {
        this.idJoueurDetruire = idJoueurDetruire;
    }

    
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public int getIdMission() {
        return idMission;
    }

    public String getMissionText() {
        String butMission = "";
        int joueurDetruire = this.idJoueurDetruire + 1;
        switch (this.idMission) {
            case 1:
                butMission = "D�truire le joueur " + joueurDetruire + ".";
                break;
            case 2:
                butMission = "Conqu�rir tous les territoires.";
                break;
            case 3:
                butMission = "Contr�ler 3 r�gions et au moins 18 territoires.";
                break;
            case 4:
                butMission = "Contr�ler 18 territoires avec au moins 2 arm�es.";
                break;
            case 5:
                butMission = "Contr�ler 30 territoires.";
                break;
            case 6:
                butMission = "Contr�ler 24 territoires.";
                break;
            case 7:
                butMission = "Contr�ler 21 territoires.";
                break;
            case 8:
                butMission = "Contr�ler la plus grosse r�gion �tant l'Asie et 1 autre r�gion.";
                break;
        }
        return butMission;
    }

    public boolean VerifMission() {
        switch (this.getIdMission()) {
            case 1:
                return this.detruireLeJoueurX();
            case 2:
                return this.conquerirTousLesTerritoires();
            case 3:
                return this.controler3RegionsEtAuMoins18Territoires();
            case 4:
                return this.controler18TerritoiresAvecAuMoins2Armees();
            case 5:
                return this.controler30Territoires();
            case 6:
                return this.controler24Territoires();
            case 7:
                return this.controler21Territoires();
            case 8:
                return this.controlerLaPlusGrosseRegionEt1AutreRegion();
        }
        return false;
    }

    public boolean detruireLeJoueurX() {
        if (map.getNbTerritoireJoueur(idJoueurDetruire) == 0) {
            return true;
        }
        return false;
    }

    public boolean conquerirTousLesTerritoires() {
        if (map.getNbTerritoireJoueur(this.getIdJoueur()) >= 42) {
            return true;
        }
        return false;
    }

    public boolean controler3RegionsEtAuMoins18Territoires() {
        String values[] = map.getNomsRegionJoueur(this.getIdJoueur()).split(" ");
        int nbRegion = values.length;
        if (map.getNbTerritoireJoueur(this.getIdJoueur()) >= 18 && nbRegion >= 3) {
            return true;
        }
        return false;
    }

    public boolean controler18TerritoiresAvecAuMoins2Armees() {
        if (map.getNbTerritoireJoueur(this.getIdJoueur()) >= 18) {
            return true;
        }
        return false;
    }

    public boolean controler30Territoires() {
        if (map.getNbTerritoireJoueur(this.getIdJoueur()) >= 30) {
            return true;
        }
        return false;
    }

    public boolean controler24Territoires() {
        if (map.getNbTerritoireJoueur(this.getIdJoueur()) >= 24) {
            return true;
        }
        return false;
    }

    public boolean controler21Territoires() {
        if (map.getNbTerritoireJoueur(this.getIdJoueur()) >= 21) {
            return true;
        }
        return false;
    }

    public boolean controlerLaPlusGrosseRegionEt1AutreRegion() {
        String values[] = map.getNomsRegionJoueur(this.getIdJoueur()).split(" ");
        int nbRegion = values.length;
        for (int i=0; i < nbRegion; i++) {
            if (nbRegion >= 2 && values[i] == "ASIE") {
                return true;
            }
        }
        return false;
    }

}
