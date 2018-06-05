
public class Cavalier extends Unite {

    static int cout = 3;
    int puissanceMax = 7;
    int puissanceMin = 2;
    int prioriteATT = 3;
    int prioriteDEF = 2;
    int mvtParTour = 1;

    public Cavalier(int idJoueur, int x, int y) {
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
