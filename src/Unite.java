import javax.print.attribute.standard.Finishings;
import javax.swing.JOptionPane;
import javax.xml.crypto.dsig.CanonicalizationMethod;

import edu.princeton.cs.introcs.StdDraw;

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
