
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Map {

    ArrayList<Territoire> territoireListe = new ArrayList<>();
    ArrayList<Territoire> listeTemp = new ArrayList<>();

    public Map(int nbJoueur) {

        listageTerritoire(nbJoueur);
        attributionTerritoire(nbJoueur);
        findTerritoiresVoisins();
    }


    public void listageTerritoire(int nbJoueur) {
        try {
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader("./src/Territoire.txt"));
            while ((ligne = fichier.readLine()) != null) {
                String values[] = ligne.split(" ");
                Random rand = new Random();
                int nombreAleatoire = 0 + rand.nextInt(nbJoueur + 1 - 0);
                int x = Integer.parseInt(values[3]);
                int y = Integer.parseInt(values[4]);
                int idRegion = Integer.parseInt(values[0]);
                int idTerritoire = Integer.parseInt(values[1]);
                Territoire t = new Territoire(values[5], idRegion, values[6], idTerritoire, nombreAleatoire, x, y, values[2]);
                territoireListe.add(t);
                listeTemp.add(t);
            }
            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void attributionTerritoire(int nbJoueur) {
        int nbTerJoueur = (listeTemp.size() / (nbJoueur + 1));
        for (int i = 0; i <= nbJoueur; i++) {
            for (int j = 0; j < nbTerJoueur; j++) {
                Random rand = new Random();
                int nombreAleatoire = 0 + rand.nextInt(listeTemp.size() - 0);
                listeTemp.get(nombreAleatoire).setIdJoueur(i);
                listeTemp.remove(nombreAleatoire);
            }
        }
    }
    
    public void findTerritoiresVoisins(){
        for(Territoire t:territoireListe){
            Territoire tmp = null;
            // TERRITOIRE A GAUCHE 
            tmp = getTerritoire(t.getPosition_x() - 1, t.getPosition_y());
            if(tmp != null){
                t.addVoisin(tmp);
                tmp = null;
            }
            // TERRITOIRE GAUCHE BAS
            tmp = getTerritoire(t.getPosition_x() - 1, t.getPosition_y() - 1);
            if(tmp != null){
                t.addVoisin(tmp);
                tmp = null;
            }
            //TERRITOIRE GAUCHE HAUT
            tmp = getTerritoire(t.getPosition_x() -1 , t.getPosition_y() + 1);
            if(tmp != null){
                t.addVoisin(tmp);
                tmp = null;
            }
            // TERRITOIRE HAUT
            tmp = getTerritoire(t.getPosition_x(), t.getPosition_y() +1 );
            if(tmp != null){
                t.addVoisin(tmp);
                tmp = null;
            }
            //TERRITOIRE BAS
            tmp = getTerritoire(t.getPosition_x() , t.getPosition_y() -1);
            if(tmp != null){
                t.addVoisin(tmp);
                tmp = null;
            }
            //TERRITOIRE DROITE
            tmp = getTerritoire(t.getPosition_x() +1, t.getPosition_y());
            if(tmp != null){
                t.addVoisin(tmp);
                tmp = null;
            }
            //TERRITOIRE DROITE HAUT
            tmp = getTerritoire(t.getPosition_x() +1, t.getPosition_y() +1);
            if(tmp != null){
                t.addVoisin(tmp);
                tmp = null;
            }
            //TERRITOIRE DROITE BAS
            tmp = getTerritoire(t.getPosition_x() +1, t.getPosition_y() -1);
            if(tmp != null){
                t.addVoisin(tmp);
                tmp = null;
            }   
        }
    }

   
    // r�cuperation du nb de territoires poss�dant un joueur
    public int getNbTerritoireJoueur(int idJoueur) {
        int nbTerritoireJoueur = 0;
        for (int i = 0; i <= 41; i++) {
            if (territoireListe.get(i).getIdJoueur() == idJoueur) {
                nbTerritoireJoueur++;
            }
        }
        return nbTerritoireJoueur;
    }

    // r�cuperation nom regions poss�dant un joueur
    public String getNomsRegionJoueur(int idJoueur) {
        String nomsRegionJoueur = "";
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        int F = 0;
        for (int i = 0; i <= 41; i++) {
            if (territoireListe.get(i).getIdRegion() == 1 && territoireListe.get(i).getIdJoueur() == idJoueur) {
                A++;
                if (A >= 4) {
                    nomsRegionJoueur = territoireListe.get(i).getNomRegion() + " " + nomsRegionJoueur;
                }
            }
            if (territoireListe.get(i).getIdRegion() == 2 && territoireListe.get(i).getIdJoueur() == idJoueur) {
                B++;
                if (B >= 9) {
                    nomsRegionJoueur = territoireListe.get(i).getNomRegion() + " " + nomsRegionJoueur;
                }
            }
            if (territoireListe.get(i).getIdRegion() == 3 && territoireListe.get(i).getIdJoueur() == idJoueur) {
                C++;
                if (C >= 6) {
                    nomsRegionJoueur = territoireListe.get(i).getNomRegion() + " " + nomsRegionJoueur;
                }
            }
            if (territoireListe.get(i).getIdRegion() == 4 && territoireListe.get(i).getIdJoueur() == idJoueur) {
                D++;
                if (D >= 7) {
                    nomsRegionJoueur = territoireListe.get(i).getNomRegion() + " " + nomsRegionJoueur;
                }
            }
            if (territoireListe.get(i).getIdRegion() == 5 && territoireListe.get(i).getIdJoueur() == idJoueur) {
                E++;
                if (E >= 12) {
                    nomsRegionJoueur = territoireListe.get(i).getNomRegion() + " " + nomsRegionJoueur;
                }
            }
            if (territoireListe.get(i).getIdRegion() == 6 && territoireListe.get(i).getIdJoueur() == idJoueur) {
                F++;
                if (F >= 4) {
                    nomsRegionJoueur = territoireListe.get(i).getNomRegion() + " " + nomsRegionJoueur;
                }
            }
        }
        return nomsRegionJoueur;
    }

    // affichage map graphiquement
    public void AffichageMap() {
        StdDraw.picture(8.5, 9, "./src/images/RISK_image_blanche.png", 14.75, 9.75);
        StdDraw.picture(8.5, 9, "./src/images/RISK_menu.png", 14.75, 9.75);
        for (int i = 0; i < territoireListe.size(); i++) {
            int x = territoireListe.get(i).getPosition_x();
            int y = territoireListe.get(i).getPosition_y();
            Color couleur = null;
            switch (territoireListe.get(i).getCouleur()) {
                case "RED":
                    couleur = StdDraw.RED;
                    break;
                case "YELLOW":
                    couleur = StdDraw.CYAN;
                    break;
                case "ORANGE":
                    couleur = StdDraw.PRINCETON_ORANGE;
                    break;
                case "BLUE":
                    couleur = StdDraw.BLUE;
                    break;
                case "GREEN":
                    couleur = StdDraw.GREEN;
                    break;
                case "PURPLE":
                    couleur = StdDraw.MAGENTA;
                    break;
            }
            StdDraw.setPenColor(couleur);
            StdDraw.filledSquare(x, y, 0.5);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.square(x, y, 0.5);
        }
    }

    // affichage map d'un joueur graphiquement
    public void AffichageMapJoueur(int idJoueur) {
        for (int i = 0; i <= 41; i++) {
            if (territoireListe.get(i).getIdJoueur() == idJoueur) {
                int x = territoireListe.get(i).getPosition_x();
                int y = territoireListe.get(i).getPosition_y();
                Color couleur = null;
                switch (territoireListe.get(i).getCouleur()) {
                    case "RED":
                        couleur = StdDraw.RED;
                        break;
                    case "YELLOW":
                        couleur = StdDraw.CYAN;
                        break;
                    case "ORANGE":
                        couleur = StdDraw.PRINCETON_ORANGE;
                        break;
                    case "BLUE":
                        couleur = StdDraw.BLUE;
                        break;
                    case "GREEN":
                        couleur = StdDraw.GREEN;
                        break;
                    case "PURPLE":
                        couleur = StdDraw.MAGENTA;
                        break;
                }
                StdDraw.setPenColor(couleur);
                StdDraw.filledSquare(x, y, 0.5);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.square(x, y, 0.5);
            }
        }
    }

    // affichage nom territoire graphiquement
    public void AffichageNomTerritoire() {
        if (StdDraw.isMousePressed()) {
            Double xx = StdDraw.mouseX();
            Double yy = StdDraw.mouseY();
            for (int i = 0; i <= 41; i++) {
                int x = territoireListe.get(i).getPosition_x();
                int y = territoireListe.get(i).getPosition_y();
                if ((x - 0.5) <= xx && xx <= (x + 0.5) && (y - 0.25) <= yy && yy <= (y + 0.25)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(1, 1, 1);
                    StdDraw.filledSquare(3, 1, 1);
                    StdDraw.filledSquare(5, 1, 1);
                    StdDraw.filledSquare(7, 1, 1);
                    StdDraw.filledSquare(9, 1, 1);
                    StdDraw.setPenColor(StdDraw.GRAY);

                    StdDraw.textLeft(0.5, 1,
                            territoireListe.get(i).getNomRegion() + "  /  " + territoireListe.get(i).getNom());
                }
            }
        }
    }

    // recuperation du nb de territoires dans une region
    public int NbTerritoiresDansRegion(String nomRegion) {
        int nbTerritoires = 0;
        for (int i = 0; i <= 41; i++) {
            if (territoireListe.get(i).getNomRegion() == nomRegion) {
                nbTerritoires++;
            }
        }
        return nbTerritoires;
    }

    public Territoire getTerritoire(int xx, int yy) {
        Territoire t = null;
        for (int i = 0; i <= 41; i++) {
            int x = territoireListe.get(i).getPosition_x();
            int y = territoireListe.get(i).getPosition_y();
            if ((x - 0.5) <= xx && xx <= (x + 0.5) && (y - 0.25) <= yy && yy <= (y + 0.25)) {
                t = territoireListe.get(i);
            }
        }
        return t;
    }
    
    public Territoire getTerritoireClicked(Double xx, Double yy) {
        Territoire t = null;
        for (int i = 0; i <= 41; i++) {
            int x = territoireListe.get(i).getPosition_x();
            int y = territoireListe.get(i).getPosition_y();
            if ((x - 0.5) <= xx && xx <= (x + 0.5) && (y - 0.25) <= yy && yy <= (y + 0.25)) {
                t = territoireListe.get(i);
            }
        }
        return t;
    }

}
