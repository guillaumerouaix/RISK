
public class Territoire extends Region{
	String nom;
	String num;
	int idJoueur;
	int position_x;
	int position_y;
	String couleur;
	
	public Territoire(String nomRegion, String idRegion, String nomTerritoire, String numTerritoire, int idjoueur, int x, int y, String couleurTerritoire) {
		super(nomRegion, idRegion);
		nom = nomTerritoire;
		num = numTerritoire;
		idJoueur = idjoueur;
		position_x = x;
		position_y = y;
		couleur = couleurTerritoire;
		
	}

	public String getNomRegion() {
		return getNomRegion();
	}
	
	public String getIdRegion() {
		return getIdRegion();
	}
	
	public String getNom() {
		return nom;
	}

	public String getNum() {
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
