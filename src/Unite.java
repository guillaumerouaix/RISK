
import java.util.Random;


public class Unite {

    int id;
    int cout;
    int puissance;
    int prioriteATT;
    int prioriteDEF;
    int mvtParTour;

    public Unite(int idJoueur) {
        id = idJoueur;
    }

    public int getId() {
        return id;
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
    
    public int compareToAttaque(Unite u) {
        int compPriorite = ((Unite) u).getPrioriteATT();        
        return compPriorite-this.prioriteATT;
    }
    
    public int compareToDef(Unite u) {
        int compPriorite = ((Unite) u).getPrioriteDEF();        
        return compPriorite-this.prioriteDEF;
    }

    public Boolean fight(Unite u2) {
        Random r = new Random();
        int puiss = 0 + r.nextInt(puissance + 1);
        int puiss2 = 0 + r.nextInt(u2.getPuissance() + 1);
        if(puiss > puiss2){
            return true;
        }else 
            return false;
    }

}
