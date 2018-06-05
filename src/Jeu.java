
import edu.princeton.cs.introcs.StdArrayIO;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import edu.princeton.cs.introcs.StdDraw;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jeu {

    int nbJoueur;
    ArrayList<Joueur> joueurListe = new ArrayList<>();
    ArrayList<Mission> missionListe = new ArrayList<>();
    ArrayList pionListe = new ArrayList();
    Map map;

    public Jeu() {

        menuInititialisationPartie();

        mapInitialisation();

        affectationMission();

        for (int j = 0; j <= 41; j++) {
            creationPion(map.territoireListe.get(j).getIdJoueur(), "soldat", map.territoireListe.get(j).getPosition_x(), map.territoireListe.get(j).getPosition_y());
        }

        premierTour();

        boolean missionVerif = false;
        while (missionVerif == false) {
            tourDeJeu();
            missionVerif = verifMission();
        }

    }

//affichage page menu, initialisation de la partie
    public void menuInititialisationPartie() {
        Menu menu = new Menu();
        nbJoueur = menu.SelectionNbJoueur();
        int[] armeeInit = {40, 40, 35, 30, 25, 20};
        for (int i = 0; i <= nbJoueur; i++) {
            joueurListe.add(new Joueur(i, armeeInit[nbJoueur]));
        }
    }

//mise � blanc de la fen�tre, affichage du logo, map et icon
    public void mapInitialisation() {
        StdDraw.clear();
        StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
        StdDraw.picture(9, 16, "./src/images/RISK_logo.jpg", 5, 2);
        StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
        StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
        StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
        StdDraw.picture(15, 3, "./src/images/RISK_boutton_fin_placement.png", 3, 1.5);
        map = new Map(nbJoueur);
        map.AffichageMap();
    }

    public void premierTour() {
        for (int i = 0; i <= nbJoueur; i++) {
            int numeroJoueur = i + 1;
            AffichageIdJoueur(numeroJoueur);
            AffihageSoldeUniteJoueur(i);
            StdDraw.picture(15, 3, "./src/images/RISK_boutton_fin_placement.png", 3, 1.5);
            JOptionPane.showMessageDialog(null, "Joueur " + numeroJoueur + " place tes armees sur tes territoires ! \nTu as " + joueurListe.get(i).getSoldeUnite() + " unites.", "Info", JOptionPane.INFORMATION_MESSAGE);
            StdDraw.picture(8.5, 9, "./src/images/RISK_image_blanche.png", 14.75, 9.75);
            StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
            map.AffichageMapJoueur(i);
            AffihageSoldeUniteJoueur(i);
            affichagePionList();
            placement(i);
        }
    }

//1 tour de jeu par joueur
    public void tourDeJeu() {
        for (int i = 0; i <= nbJoueur; i++) {
            int numeroJoueur = i + 1;
            AffichageIdJoueur(numeroJoueur);
            AffihageSoldeUniteJoueur(i);
            StdDraw.picture(15, 3, "./src/images/RISK_boutton_fin_placement.png", 3, 1.5);
            JOptionPane.showMessageDialog(null, "Joueur " + numeroJoueur + " A toi de jouer ! \nIl te reste " + joueurListe.get(i).getSoldeUnite() + " unites.", "Info", JOptionPane.INFORMATION_MESSAGE);
            StdDraw.picture(8.5, 9, "./src/images/RISK_image_blanche.png", 14.75, 9.75);
            StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
            map.AffichageMapJoueur(i);
            affichagePionList();
            JOptionPane.showMessageDialog(null, "Place tes armees sur la map !", "Placement", JOptionPane.INFORMATION_MESSAGE);
            placement(i);
            StdDraw.picture(15, 3, "./src/images/RISK_boutton_fin_attaque.png", 3, 1.5);
            JOptionPane.showMessageDialog(null, "Attaque des territoires !", "Attaque", JOptionPane.INFORMATION_MESSAGE);
            phaseAttaque(i);
            ReceptionRenfort(i);
        }
    }

    public void placement(int idJoueur) {
        int j = 0;
        int valReturn = 0;
        while (j < 1) {
            map.AffichageNomTerritoire();
            while (joueurListe.get(idJoueur).getSoldeUnite() > 0) {
                map.AffichageNomTerritoire();
                String typeUnite = selectionTypeUnite(idJoueur);
                if (typeUnite != "" && typeUnite != "fin") {
                    recupPosition(idJoueur, typeUnite, "placement");
                    map.AffichageMapJoueur(idJoueur);
                    affichagePionList();
                    AffihageSoldeUniteJoueur(idJoueur);
                    StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
                    StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
                    StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
                }
            }
            JOptionPane.showMessageDialog(null, "Vous pouvez maintenant deplacer des troupes", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
            while (valReturn == 0) {
                valReturn = deplacementPionPlacement(idJoueur, valReturn);
            }
            j++;

            StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
            StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
            StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
        }
    }

    public void phaseAttaque(int idJoueur) {
        int j = 0;
        int val = 0;
        while (j < 1) {
            attaque(idJoueur);
        }
    }

    public void attaque(int idJoueur) {
        map.AffichageNomTerritoire();
        JOptionPane.showMessageDialog(null, "Selectionnez un territoire duquel attaquer", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
        Territoire t = null;
        while (t == null) {
            t = getTerritoireAttaque(idJoueur);
        }
        if (t != null && t.getListUnite().size() > 1) {
            System.out.println(t.getNom());
            JOptionPane.showMessageDialog(null, "Selectionnez un territoire à attaquer", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
            Territoire t2 = null;
            while (t2 == null) {
                t2 = getTerritoireAAttaquer(idJoueur);
            }
            if (t2 != null) {
                System.out.println(t2.getNom());
                int gagnant = t.attaquer(t2, map);
                System.out.println("Gagnant de la bataille = Joueur " + gagnant);
                JOptionPane.showMessageDialog(null, "Gagnant de la bataille = Joueur " + (gagnant + 1), "Deplacement", JOptionPane.INFORMATION_MESSAGE);
                StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
                map.AffichageMapJoueur(idJoueur);
                affichagePionList();
                AffihageSoldeUniteJoueur(idJoueur);
            }
        }
    }

    private Territoire getTerritoireAttaque(int idJoueur) {
        if (StdDraw.isMousePressed()) {
            wait(1);
            Double xx = StdDraw.mouseX();
            Double yy = StdDraw.mouseY();
            if (13.5 <= xx && xx <= 16.5 && 2.25 <= yy && yy <= 3.25) {
                return null;
            }
            Territoire t = map.getTerritoireClicked(xx, yy);
            if (t != null && t.getIdJoueur() == idJoueur) {
                return t;
            }
        }
        return null;
    }

    private Territoire getTerritoireAAttaquer(int idJoueur) {
        if (StdDraw.isMousePressed()) {
            wait(1);
            Double xx = StdDraw.mouseX();
            Double yy = StdDraw.mouseY();
            if (13.5 <= xx && xx <= 16.5 && 2.25 <= yy && yy <= 3.25) {
                return null;
            }
            Territoire t = map.getTerritoireClicked(xx, yy);
            if (t != null && t.getIdJoueur() != idJoueur) {
                return t;
            }
        }
        return getTerritoireAttaque(idJoueur);
    }

//rep�re le type d'unit� s�lectionn�e
    public String selectionTypeUnite(int idJoueur) {
        String typeUnite = "";
        if (StdDraw.isMousePressed()) {
            Double xx = StdDraw.mouseX();
            Double yy = StdDraw.mouseY();
            if (7.5 <= xx && xx <= 8.5 && 2.25 <= yy && yy <= 3.25) {
                if (joueurListe.get(idJoueur).getSoldeUnite() >= Cavalier.getCout()) {
                    StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon_selectionnee.png", 1, 1.5);
                    StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
                    StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
                    typeUnite = "cavalier";
                } else {
                    JOptionPane.showMessageDialog(null, "Vous n'avez que " + joueurListe.get(idJoueur).getSoldeUnite() + " unites !\nUn cavalier en coute " + Cavalier.getCout() + ".", "Info", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (1.5 <= xx && xx <= 2.5 && 2.25 <= yy && yy <= 3.25) {
                if (joueurListe.get(idJoueur).getSoldeUnite() >= Soldat.getCout()) {
                    StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
                    StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon_selectionnee.png", 1, 1.5);
                    StdDraw.picture(5, 3, "./src/images/RISK_canon_icon.png", 1.5, 2);
                    typeUnite = "soldat";
                } else {
                    JOptionPane.showMessageDialog(null, "Vous n'avez que " + joueurListe.get(idJoueur).getSoldeUnite() + " unites !\nUn soldat en coute " + Soldat.getCout() + ".", "Info", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (4.25 <= xx && xx <= 5.75 && 2.25 <= yy && yy <= 3.25) {
                if (joueurListe.get(idJoueur).getSoldeUnite() >= Canon.getCout()) {
                    StdDraw.picture(8, 3, "./src/images/RISK_cavalier_icon.png", 1, 1.5);
                    StdDraw.picture(2, 3, "./src/images/RISK_soldat_icon.png", 1, 1.5);
                    StdDraw.picture(5, 3, "./src/images/RISK_canon_icon_selectionnee.png", 1.5, 2);
                    typeUnite = "canon";
                } else {
                    JOptionPane.showMessageDialog(null, "Vous n'avez que " + joueurListe.get(idJoueur).getSoldeUnite() + " unites !\nUn canon en coute " + Canon.getCout() + ".", "Info", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (13.5 <= xx && xx <= 16.5 && 2.25 <= yy && yy <= 3.25) {
                return "fin";
            }
        }
        return typeUnite;
    }

    public int deplacementPionPlacement(int idJoueur, int valReturn) {
        if (StdDraw.isMousePressed()) {
            wait(1);
            Double xx = StdDraw.mouseX();
            Double yy = StdDraw.mouseY();
            if (13.5 <= xx && xx <= 16.5 && 2.25 <= yy && yy <= 3.25) {
                return 1;
            }
            Territoire t = map.getTerritoireClicked(xx, yy);
            if (t != null && t.getIdJoueur() == idJoueur) {
                Unite u = getUniteTypeClicked(xx, yy, t.getPosition_x(), t.getPosition_y(), t);;
                if (u != null) {
                    System.out.println(u);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (t.getListUnite().size() <= 1) {
                        JOptionPane.showMessageDialog(null, "Pas assez d'unite sur le teritoire pour en deplacer", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
                        return 0;
                    }
                    waitEtDeplace(t, u, idJoueur);
                    return 0;
                }
            }
        }
        return 0;
    }

    public Unite getUniteTypeClicked(Double xx, Double yy, int x, int y, Territoire t) {
        Unite u = null;
        if ((x - 0.32 - 0.15) <= xx && xx <= (x - 0.32 + 0.15) && (y - 0.2 - 0.25) <= yy && yy <= (y - 0.2 + 0.25)) {
            //cavalier
            return t.getRandomCavalier();
        }

        if ((x + 0.32 - 0.15) <= xx && xx <= (x + 0.32 + 0.15) && (y - 0.2 - 0.25) <= yy && yy <= (y - 0.2 + 0.25)) {
            //soldat
            return t.getRandomSoldat();
        }
        if ((x - 0.15) <= xx && xx <= (x + 0.15) && (y - 0.2 - 0.25) <= yy && yy <= (y - 0.2 + 0.25)) {
            //canon
            return t.getRandomCanon();
        }
        return u;
    }

    public Territoire waitTerritoire(int idJoueur) {
        Territoire t = null;
        wait(1);
        while (!StdDraw.isMousePressed()) {

        }
        if (StdDraw.isMousePressed()) {
            wait(1);
            Double xx = StdDraw.mouseX();
            Double yy = StdDraw.mouseY();
            t = map.getTerritoireClicked(xx, yy);
            if (t != null && t.getIdJoueur() == idJoueur) {
                return t;
            }
        }
        return t;
    }

    private void deplacerPion(Territoire t, Territoire t2, Unite u, int idJoueur) {
        if (!t.getListVoisins().contains(t2)) {
            JOptionPane.showMessageDialog(null, "Territoire non voisin", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
            waitEtDeplace(t, u, idJoueur);
        }
        t2.addUnite(u);
        t.removeUnite(u);
        System.out.println("deplacement de : " + t.getNom() + " vers : " + t2.getNom());
        map.AffichageMapJoueur(idJoueur);
        affichagePionList();
        AffihageSoldeUniteJoueur(idJoueur);
    }

    private void waitEtDeplace(Territoire t, Unite u, int idJoueur) {
        JOptionPane.showMessageDialog(null, "Dans quel territoire voulez vous deplacer ce pion", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
        Territoire t2 = waitTerritoire(idJoueur);
        if (t2 != null && t2.getIdJoueur() == idJoueur) {
            deplacerPion(t, t2, u, idJoueur);
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Territoire non reconnu, veuillez reesayer", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
            waitEtDeplace(t, u, idJoueur);
        }
    }

    //d�placement d'un pion lors d'une attaque
    public String deplacementPion(int idJoueur) {
        String ligne;
        int j = 0;
        while (j < 1) {
            if (StdDraw.isMousePressed()) {
                Double xx = StdDraw.mouseX();
                Double yy = StdDraw.mouseY();
                for (int i = 0; i < pionListe.size(); i++) {
                    ligne = (String) pionListe.get(i);
                    String values[] = ligne.split(" ");
                    int idJoueur2 = Integer.parseInt(values[0]);
                    String typeUnite = values[1];
                    int x = Integer.parseInt(values[2]);
                    int y = Integer.parseInt(values[3]);
                    if (x - 0.32 - 0.15 <= xx && xx <= x - 0.32 + 0.15 && y - 0.2 - 0.25 <= yy && yy <= y - 0.2 + 0.25) {
                        if (idJoueur2 == idJoueur) {
                            pionListe.remove(pionListe.get(i));
                            JOptionPane.showMessageDialog(null, "Pion enleve", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
                            recupPosition(idJoueur, typeUnite, "attaque");
                            j++;
                        }
                    }
                    if (x + 0.32 - 0.15 <= xx && xx <= x + 0.32 + 0.15 && y - 0.2 - 0.25 <= yy && yy <= y - 0.2 + 0.25) {
                        if (idJoueur2 == idJoueur) {
                            pionListe.remove(pionListe.get(i));
                            JOptionPane.showMessageDialog(null, "Pion enleve", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
                            recupPosition(idJoueur, typeUnite, "attaque");
                            j++;
                        }
                    }
                    if (x - 0.15 <= xx && xx <= x + 0.15 && y - 0.2 - 0.25 <= yy && yy <= y - 0.2 + 0.25) {
                        if (idJoueur2 == idJoueur) {
                            pionListe.remove(pionListe.get(i));
                            JOptionPane.showMessageDialog(null, "Pion enleve", "Deplacement", JOptionPane.INFORMATION_MESSAGE);
                            recupPosition(idJoueur, typeUnite, "attaque");
                            j++;
                        }
                    }
                    if (13.5 <= xx && xx <= 16.5 && 2.25 <= yy && yy <= 3.25) {
                        j++;
                        return "fin";
                    }
                }
            }
        }
        return "";
    }

//creation d'un pion
    public void creationPion(int idJoueur, String typeUnite, int x, int y) {
        Territoire t;
        t = map.getTerritoire(x, y);
        if (t == null) {
            return;
        }
        switch (typeUnite) {
            case "cavalier":
                Cavalier c = new Cavalier(idJoueur, x, y);
                pionListe.add(idJoueur + " " + typeUnite + " " + x + " " + y);
                joueurListe.get(idJoueur).setSoldeUnite(joueurListe.get(idJoueur).getSoldeUnite() - Cavalier.getCout());
                map.territoireListe.get(t.getNum()).addUnite(c);
                break;
            case "soldat":
                Soldat s = new Soldat(idJoueur, x, y);
                pionListe.add(idJoueur + " " + typeUnite + " " + x + " " + y);
                joueurListe.get(idJoueur).setSoldeUnite(joueurListe.get(idJoueur).getSoldeUnite() - Soldat.getCout());
                map.territoireListe.get(t.getNum()).addUnite(s);

                break;
            case "canon":
                Canon ca = new Canon(idJoueur, x, y);
                pionListe.add(idJoueur + " " + typeUnite + " " + x + " " + y);
                joueurListe.get(idJoueur).setSoldeUnite(joueurListe.get(idJoueur).getSoldeUnite() - Canon.getCout());
                map.territoireListe.get(t.getNum()).addUnite(ca);

                break;
        }
    }

    public void recupPosition(int idJoueur, String typeUnite, String typeCreation) {
        int i = 0;
        while (i < 1) {
            if (StdDraw.isMousePressed()) {
                map.AffichageNomTerritoire();
                Double xx = StdDraw.mouseX();
                Double yy = StdDraw.mouseY();
                for (int j = 0; j <= 41; j++) {
                    int x = map.territoireListe.get(j).getPosition_x();
                    int y = map.territoireListe.get(j).getPosition_y();
                    if ((x - 0.5) <= xx && xx <= (x + 0.5) && (y - 0.25) <= yy && yy <= (y + 0.25) && map.territoireListe.get(j).getIdJoueur() == idJoueur && typeCreation == "placement") {
                        creationPion(idJoueur, typeUnite, x, y);
                        i++;
                    }
                    if ((x - 0.5) <= xx && xx <= (x + 0.5) && (y - 0.25) <= yy && yy <= (y + 0.25) && map.territoireListe.get(j).getIdJoueur() != idJoueur && typeCreation == "attaque") {
                        creationPion(idJoueur, typeUnite, x, y);
                        i++;
                    }
                }
            }
        }
    }

//affichage des pions pr�sents sur la map
    public void AffichagePions() {
        String ligne;
        String ligne2;
        int k;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < pionListe.size(); i++) {
            ligne = (String) pionListe.get(i);
            String values[] = ligne.split(" ");
            int idJoueur = Integer.parseInt(values[0]);
            String typePion = values[1];
            int x = Integer.parseInt(values[2]);
            int y = Integer.parseInt(values[3]);
            k = 0;
            for (int j = 0; j < pionListe.size(); j++) {
                ligne2 = (String) pionListe.get(j);
                String values2[] = ligne.split(" ");
                int idJoueur2 = Integer.parseInt(values2[0]);
                String typePion2 = values2[1];
                int x2 = Integer.parseInt(values2[2]);
                int y2 = Integer.parseInt(values2[3]);
                if (idJoueur == idJoueur2 && x == x2 && y == y2) {
                    k++;
                    System.out.println("nb soldat " + k + " " + pionListe.size() + " " + ligne + " " + ligne2);
                }
            }
            switch (typePion) {
                case "cavalier":
                    if (k >= 1) {
                        StdDraw.textLeft(x - 0.38, y + 0.20, "" + k);
                    }
                    StdDraw.picture(x - 0.32, y - 0.20, "./src/images/RISK_cavalier_jeton" + idJoueur + ".png", 0.30, 0.5);
                    break;
                case "soldat":
                    if (k >= 1) {
                        StdDraw.textLeft(x + 0.27, y + 0.20, "" + k);
                    }
                    StdDraw.picture(x + 0.32, y - 0.20, "./src/images/RISK_soldat_jeton" + idJoueur + ".png", 0.30, 0.5);
                    break;
                case "canon":
                    if (k >= 1) {
                        StdDraw.textLeft(x - 0.05, y + 0.20, "" + k);
                    }
                    StdDraw.picture(x, y - 0.20, "./src/images/RISK_canon_jeton" + idJoueur + ".png", 0.30, 0.5);
                    break;
            }
        }
    }

    public void affichagePionList() {
        StdDraw.setPenColor(StdDraw.BLACK);
        for (Territoire t : map.territoireListe) {
            int cav = t.getNbCavalier();
            int sol = t.getNbSoldat();
            int can = t.getNbCanon();
            if (cav >= 1) {
                StdDraw.textLeft(t.getPosition_x() - 0.38, t.getPosition_y() + 0.20, "" + cav);
                StdDraw.picture(t.getPosition_x() - 0.32, t.getPosition_y() - 0.20, "./src/images/RISK_cavalier_jeton" + t.getIdJoueur() + ".png", 0.30, 0.5);
            }
            if (sol >= 1) {
                StdDraw.textLeft(t.getPosition_x() + 0.27, t.getPosition_y() + 0.20, "" + sol);
                StdDraw.picture(t.getPosition_x() + 0.32, t.getPosition_y() - 0.20, "./src/images/RISK_soldat_jeton" + t.getIdJoueur() + ".png", 0.30, 0.5);
            }
            if (can >= 1) {
                StdDraw.textLeft(t.getPosition_x() - 0.05, t.getPosition_y() + 0.20, "" + can);
                StdDraw.picture(t.getPosition_x(), t.getPosition_y() - 0.20, "./src/images/RISK_canon_jeton" + t.getIdJoueur() + ".png", 0.30, 0.5);
            }
        }
    }

//rajout d'unites a la fin d'un tour
    public void ReceptionRenfort(int idJoueur) {
        int renfort = 0;
        int nbTerritoires = map.getNbTerritoireJoueur(idJoueur);
        renfort = (int) Math.floor(nbTerritoires / 3);
        System.out.println("nb renfort " + renfort);
        System.out.println("nb territoires " + nbTerritoires);
        String Regions = map.getNomsRegionJoueur(idJoueur);
        String values[] = Regions.split(" ");
        int nbRegions = values.length;
        System.out.println("nb regions " + nbRegions);
        if (Regions != "") {
            for (int i = 0; i < nbRegions; i++) {
                renfort = renfort + (int) Math.floor(map.NbTerritoiresDansRegion(values[i]) / 2);
            }
        }
        joueurListe.get(idJoueur).setSoldeUnite(joueurListe.get(idJoueur).getSoldeUnite() + renfort);
        System.out.println("Fin du tour du joueur " + idJoueur + ", reception de " + renfort + " unites");

    }

//affectation des missions aux joueurs
    public void affectationMission() {
        int j = 0;
        for (int i = 0; i <= nbJoueur; i++) {
            missionListe.add(new Mission(i));
            j = i + 1;
            JOptionPane.showMessageDialog(null, "Attention ! \nJoueur " + j + ", ta mission va etre devoilee, seul toi dois la connaitre.", "Mission", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Joueur " + j + ", voici ta mission : \n" + missionListe.get(i).getMissionText(), "Mission", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean verifMission() {
        int i = 0;
        boolean mission = false;
        while (i <= nbJoueur || mission == true) {
            mission = missionListe.get(i).VerifMission();
            if (mission == true) {
                missionListe.get(i).VerifMission();
                int idJoueur = missionListe.get(i).getIdJoueur() + 1;
                String missionText = missionListe.get(i).getMissionText();
                StdDraw.clear();
                StdDraw.picture(9.1, 9, "./src/images/RISK_n1.png", 7, 9);
                StdDraw.picture(9, 16, "./src/images/RISK_logo.jpg", 5, 2);
                JOptionPane.showMessageDialog(null, "Bravo Joueur " + idJoueur + " ! \nTu as accompli ta mission :\n" + missionText, "Winner", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }

//affichage du numero du joueur qui doit jouer
    public void AffichageIdJoueur(int idJoueur) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(0.5, 16, 0.5);
        StdDraw.filledSquare(1, 16, 0.5);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.textLeft(0.5, 16, "Joueur " + idJoueur);
    }

//affichage solde d'unites du joueur 	
    public void AffihageSoldeUniteJoueur(int idJoueur) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(0.5, 15, 0.5);
        StdDraw.filledSquare(1, 15, 0.5);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.textLeft(0.5, 15, "Unite : " + joueurListe.get(idJoueur).getSoldeUnite());
    }

    public void wait(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
