
public class Territoire extends Region{
	String nom;
	String num;
	String source = "./src/Territoire.txt";
	
	public Territoire(String nom, String id, String nomTerritoire, String numTerritoire) {
		super(nomTerritoire, nomTerritoire);
		nom = nomTerritoire;
		num = numTerritoire;
	}

	public String getNom() {
		return nom;
	}

	public String getNum() {
		return num;
	}
	

	
}
