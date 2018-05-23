
public class Soldat extends Unite{
	
	static int cout = 1;
	int puissance = 1;
	int prioriteATT = 2;
	int prioriteDEF = 1;
	int mvtParTour = 2;
	
	public Soldat(int nombreUnites, int idJoueur, Double x, Double y) {
		super(nombreUnites, idJoueur);
	}

	public static int getCout() {
		return cout;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getPrioriteATT() {
		return prioriteATT;
	}

	public void setPrioriteATT(int prioriteATT) {
		this.prioriteATT = prioriteATT;
	}

	public int getPrioriteDEF() {
		return prioriteDEF;
	}

	public void setPrioriteDEF(int prioriteDEF) {
		this.prioriteDEF = prioriteDEF;
	}

	public int getMvtParTour() {
		return mvtParTour;
	}

	public void setMvtParTour(int mvtParTour) {
		this.mvtParTour = mvtParTour;
	}

}
