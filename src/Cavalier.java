
public class Cavalier extends Unite {

    static int cout = 7;
    int puissance = 4;
    int prioriteATT = 3;
    int prioriteDEF = 2;
    int mvtParTour = 1;

    public Cavalier(int idJoueur, int x, int y) {
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
