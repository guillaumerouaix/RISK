
public class Unite {
	
	Unite [] tabUnite;
	int nombre;
	int id;
	 
	public Unite(int nombreUnites, int idJoueur) {
		nombre = nombreUnites;
		id = idJoueur;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}

}
