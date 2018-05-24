
public class Territoire extends Region{
	String nom;
	int num;
	int idJoueur;
	int position_x;
	int position_y;
	String couleur;
	
	public Territoire(String nomRegion, int idRegion, String nomTerritoire, int numTerritoire, int idjoueur, int x, int y, String couleurTerritoire) {
		super(nomRegion, idRegion);
		nom = nomTerritoire;
		num = numTerritoire;
		idJoueur = idjoueur;
		position_x = x;
		position_y = y;
		couleur = couleurTerritoire;
		
	}

	public String getNomRegion() {
		return super.nom;
	}
	
	public int getIdRegion() {
		return super.id;
	}
	
	public String getNom() {
		return nom;
	}

	public int getNum() {
		return num;
	}

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public int getPosition_x() {
		return position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public String getCouleur() {
		return couleur;
	}
	
}
