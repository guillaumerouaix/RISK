
public class Canon extends Unite{
	
	static int cout = 3;
	int puissance = 2;
	int prioriteATT = 1;
	int prioriteDEF = 3;
	int mvtParTour = 3;
	
	public Canon(int idJoueur, int x, int y) {
		super(idJoueur);
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
