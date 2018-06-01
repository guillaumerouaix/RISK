
public class Joueur {
	
	private int id;
	private int soldeUnite;
	
	public Joueur(int idJoueur, int nbUnite) {
		id = idJoueur;
		soldeUnite = nbUnite;
	}
	
	public  int getId() {
		return id;
	}

	public int getSoldeUnite() {
		return soldeUnite;
	}

	public void setSoldeUnite(int soldeUnite) {
		this.soldeUnite = soldeUnite;
	}
	
}
