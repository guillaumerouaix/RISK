
public class Canon extends Unite{
	
	int cout = 3;
	int puissance = 2;
	int prioriteATT = 1;
	int prioriteDEF = 3;
	int mvtParTour = 3;
	
	public Canon(int nombreUnites) {
		super(nombreUnites);
	}
	
	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
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
