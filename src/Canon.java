
public class Canon extends Unite {

    static int cout = 7;
    int puissanceMax = 9;
    int puissanceMin = 4;
    int prioriteATT = 1;
    int prioriteDEF = 3;
    int mvtParTour = 3;

    public Canon(int idJoueur, int x, int y) {
        super(idJoueur);
    }

    public static int getCout() {
        return cout;
    }

    public int getPuissanceMax() {
        return puissanceMax;
    }

    public void setPuissanceMax(int puissanceMax) {
        this.puissanceMax = puissanceMax;
    }

    public int getPuissanceMin() {
        return puissanceMin;
    }

    public void setPuissanceMin(int puissanceMin) {
        this.puissanceMin = puissanceMin;
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
