
public class Region {
	String nomRegion;
	String idRegion;
	static String source = "./src/Territoire.txt";
	
	public Region(String nom, String id) {
		nomRegion = nom;
		idRegion = id;
	}
	
	public String getNom() {
		return nomRegion;
	}
	
	public String getId() {
		return idRegion;
	}
	
}
