
import java.util.Random;

public class Unite {

    int id;
    int cout;
    int puissanceMax;
    int puissanceMin;
    int prioriteATT;
    int prioriteDEF;
    int mvtParTour;

    public Unite(int idJoueur) {
        id = idJoueur;
    }

    public int getId() {
        return id;
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

    public int compareToAttaque(Unite u) {
        int compPriorite = ((Unite) u).getPrioriteATT();
        return compPriorite - this.prioriteATT;
    }

    public int compareToDef(Unite u) {
        int compPriorite = ((Unite) u).getPrioriteDEF();
        return compPriorite - this.prioriteDEF;
    }

    public Boolean fight(Unite u2) {
        Random r = new Random();
        System.out.println(this.getClass().getName());
        System.out.println(this.puissanceMax);
        System.out.println(this.puissanceMin);
        int puiss = r.nextInt((this.puissanceMax - this.puissanceMin) + 1) + this.puissanceMin;
        System.out.println("puiss attaque : " + puiss);
        int puiss2 = r.nextInt((u2.getPuissanceMax() - u2.getPuissanceMin()) + 1) + u2.getPuissanceMin();
        System.out.println("puiss def : " + puiss2);
        if (puiss > puiss2) {
            System.out.println("att gagne");
            return true;
        } else {
            System.out.println("def gagne");
        }
        return false;
    }

}
