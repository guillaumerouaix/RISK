
public class Soldat extends Unite {

    static int cout = 1;
    int puissanceMax = 6;
    int puissanceMin = 1;
    int prioriteATT = 2;
    int prioriteDEF = 1;
    int mvtParTour = 2;

    public Soldat(int idJoueur, int x, int y) {
        super(idJoueur);
    }

    public static int getCout() {
        return cout;
    }

    public int getPuissanceMax() {
        return puissanceMax;
    }

    public void setPuissanceMax(int puissance) {
        this.puissanceMax = puissance;
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
