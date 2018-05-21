
public class Region {
	String nom;
	String id;
	static String source = "./src/Territoire.txt";
	
	public Region(String nomRegion, String idRegion) {
		nom = nomRegion;
		id = idRegion;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getId() {
		return id;
	}
	
}
