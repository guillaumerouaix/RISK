
import java.awt.List;
import java.util.ArrayList;

public class Territoire extends Region {

    private String nom;
    private int num;
    private int idJoueur;
    private int position_x;
    private int position_y;
    private String couleur;
    private ArrayList<Unite> listUnite;

    public Territoire(String nomRegion, int idRegion, String nomTerritoire, int numTerritoire, int idjoueur, int x, int y, String couleurTerritoire) {
        super(nomRegion, idRegion);
        nom = nomTerritoire;
        num = numTerritoire;
        idJoueur = idjoueur;
        position_x = x;
        position_y = y;
        couleur = couleurTerritoire;
        listUnite = new ArrayList<>();

    }

    public String getNomRegion() {
        return super.nom;
    }

    public int getIdRegion() {
        return super.id;
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public int getPosition_x() {
        return position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public String getCouleur() {
        return couleur;
    }

    public ArrayList<Unite> getListUnite() {
        return listUnite;
    }

    public void setListUnite(ArrayList<Unite> listUnite) {
        this.listUnite = listUnite;
    }
    
    public int getNbSoldat(){
        int cpt = 0;
        for(int i=0; i<listUnite.size(); i++){
            if(listUnite.get(i).getClass().getName() == "Soldat")
                cpt++;
        }
        return cpt;
    }
    
    public int getNbCavalier(){
        int cpt = 0;
        for(int i=0; i<listUnite.size(); i++){
            if(listUnite.get(i).getClass().getName() == "Cavalier")
                cpt++;
        }
        return cpt;
    }
    
    public int getNbCanon(){
        int cpt = 0;
        for(int i=0; i<listUnite.size(); i++){
            if(listUnite.get(i).getClass().getName() == "Canon")
                cpt++;
        }
        return cpt;
    }
    
    public void addUnite(Unite u){
        listUnite.add(u);
        System.out.println("territoire : " + this.nom + " taille : " + listUnite.size() + " unite : " + u.getClass().getName() + " joueur : " + idJoueur);
    }
    
    public void removeUnite(Unite u){
        listUnite.remove(u);
    }
}
