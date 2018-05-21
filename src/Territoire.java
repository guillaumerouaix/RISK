
public class Territoire extends Region{
	String nom;
	String num;
	int idJoueur;
	String position_x;
	String position_y;
	String couleur;
	
	public Territoire(String nomRegion, String idRegion, String nomTerritoire, String numTerritoire, int idjoueur, String values, String values2, String couleurTerritoire) {
		super(nomRegion, idRegion);
		nom = nomTerritoire;
		num = numTerritoire;
		idJoueur = idjoueur;
		position_x = values;
		position_y = values2;
		couleur = couleurTerritoire;
		
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

	public String getPosition_x() {
		return position_x;
	}

	public String getPosition_y() {
		return position_y;
	}

	public String getCouleur() {
		return couleur;
	}
	
}
