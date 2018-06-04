
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Territoire extends Region {

    private String nom;
    private int num;
    private int idJoueur;
    private int position_x;
    private int position_y;
    private String couleur;
    private ArrayList<Unite> listUnite;
    private ArrayList<Territoire> listVoisins;

    public Territoire(String nomRegion, int idRegion, String nomTerritoire, int numTerritoire, int idjoueur, int x, int y, String couleurTerritoire) {
        super(nomRegion, idRegion);
        nom = nomTerritoire;
        num = numTerritoire;
        idJoueur = idjoueur;
        position_x = x;
        position_y = y;
        couleur = couleurTerritoire;
        listUnite = new ArrayList<>();
        listVoisins = new ArrayList<>();
        listVoisins.add(this);

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

    public ArrayList<Territoire> getListVoisins() {
        return listVoisins;
    }

    public void setListVoisins(ArrayList<Territoire> listVoisins) {
        this.listVoisins = listVoisins;
    }

    public void addVoisin(Territoire t) {
        this.listVoisins.add(t);
    }

    public void removeVoisin(Territoire t) {
        this.listVoisins.remove(t);
    }

    public int getNbSoldat() {
        int cpt = 0;
        for (int i = 0; i < listUnite.size(); i++) {
            if (listUnite.get(i).getClass().getName() == "Soldat") {
                cpt++;
            }
        }
        return cpt;
    }

    public int getNbCavalier() {
        int cpt = 0;
        for (int i = 0; i < listUnite.size(); i++) {
            if (listUnite.get(i).getClass().getName() == "Cavalier") {
                cpt++;
            }
        }
        return cpt;
    }

    public int getNbCanon() {
        int cpt = 0;
        for (int i = 0; i < listUnite.size(); i++) {
            if (listUnite.get(i).getClass().getName() == "Canon") {
                cpt++;
            }
        }
        return cpt;
    }

    public void addUnite(Unite u) {
        listUnite.add(u);
    }

    public void removeUnite(Unite u) {
        listUnite.remove(u);
    }

    public Unite getRandomCavalier() {
        for (Unite u : listUnite) {
            if (u.getClass().getName() == "Cavalier") {
                return u;
            }
        }
        return null;
    }

    public Unite getRandomSoldat() {
        for (Unite u : listUnite) {
            if (u.getClass().getName() == "Soldat") {
                return u;
            }
        }
        return null;
    }

    public Unite getRandomCanon() {
        for (Unite u : listUnite) {
            if (u.getClass().getName() == "Canon") {
                return u;
            }
        }
        return null;
    }

    public int attaquer(Territoire t2) {
        this.orgaByAttaque();
        t2.orgaByDefense();
        ArrayList<Unite> l1 = new ArrayList<>(listUnite);
        ArrayList<Unite> l2 = new ArrayList<>(t2.getListUnite());
        for (Unite u : listUnite) {
            for (Unite u2 : t2.getListUnite()) {
                if (u.fight(u2)) {
                    l2.remove(u2);
                    continue;
                } else {
                    l1.remove(u);
                    continue;
                }
            }
        }
        if (l1.size() > 1) {
            t2.setIdJoueur(idJoueur);
            setListUnite(l1);
            return idJoueur;
        } else {
            setIdJoueur(t2.getIdJoueur());
            listUnite = new ArrayList<>();
            addUnite(new Soldat(t2.getIdJoueur(), 0, 0));
            return t2.getIdJoueur();
        }
    }

    private void orgaByAttaque() {
        Collections.sort(listUnite, new Comparator<Unite>() {
            public int compare(Unite one, Unite two) {
                return one.compareToAttaque(two);
            }
        });
    }

    private void orgaByDefense() {
        Collections.sort(listUnite, new Comparator<Unite>() {
            public int compare(Unite one, Unite two) {
                return one.compareToDef(two);
            }
        });
    }
}
