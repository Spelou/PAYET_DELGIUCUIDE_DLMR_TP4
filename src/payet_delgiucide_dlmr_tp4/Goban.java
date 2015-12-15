/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quentin
 */
public class Goban {

    //attributs
    private Pierre[][] plateau; //plateau de jeu, matrice de pierre
    private ArrayList<Groupe> listeGroupes;
    private int taille;
    private int pierreMorteB;
    private int pierreMorteN;

// constructeur de Goban 
//taille en paramètre supposée juste, intialise toutes les pierres à vide, initialise les pierres mortes à 0
    public Goban(int taille) {
        //intialiser la taille du plateau
        this.taille = taille;
        //initialisation plateau
        plateau = new Pierre[taille][taille];
        //création d'une pierre vide

        //initialisation du terrain, on met des pierres vides partout
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                Pierre pierreVide = new Pierre("O", -1, 0, -1);
                plateau[i][j] = pierreVide;
                // System.out.println(plateau[i][j].getEtat()); //juste pour vérifier
            }
        }
        //initialisation des pierres mortes
        pierreMorteB = 0;
        pierreMorteN = 0;
        //liste Groupe
        listeGroupes = new ArrayList<Groupe>();
    }

// méthode d'affichage - écrit les numéros des colonnes ainsi que ceux des lignes 
//puis les pierres vivantes qui sont contenues dans la matrice (Noir N, bBlanc B) O sinon
    public void afficher() {
        System.out.println("=======================================");
        System.out.println("Affichage du plateau");
        // affichage de la première ligne tel que 0 1 .. 18
        System.out.print("G |");
        for (int i = 0; i < taille; i++) {
            if (i < 10) {
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
        //affichage de tirets
        for (int i = 0; i < (3 * taille + 3); i++) {
            System.out.print("-");
        }
        System.out.println("");

        //affichage du numéro de ligne puis des pierre vivantes contenues dans la matrice
        for (int j = 0; j < taille; j++) {
            // affichage avec décalage
            if (j < 10) {
                System.out.print(j + " |");
            } else {
                System.out.print(j + "|");
            }

            for (int k = 0; k < taille; k++) {
                if ((plateau[j][k].getEtat() == 0) || (plateau[j][k].getEtat() == 2)) {
                    System.out.print(plateau[j][k].getCouleur() + "  ");
                } else {
                    System.out.print("O  ");
                }
            }
            System.out.println("");
        }
        System.out.println("=======================================");
    }

// méthode qui place la pierre à l'endroit indiqué par l'utilisateur (deux entiers en paramètre) et une couleur 
// supposés justes et qui met à jour son degré de liberté
    public void poserPierre(int x, int y, String coul) {
        //ajout de la pierre si case non vide, On attend encore la gestion des suicides...

        if (estVide(x, y)) { //vérification case vide
            if (!(degreLib(x, y) == 0)) {   //vérification si liberte non nul        
                //Pierre nouvPierre = new Pierre(coul, 1, degreLib(x,y), listeGroupes.size());
                plateau[x][y].setCouleur(coul);
                plateau[x][y].setEtat(2);
                plateau[x][y].setLiberte(degreLib(x, y));
                plateau[x][y].setNumGroupe(0);//à faire
                System.out.println(plateau[x][y].toString());
            } else {
                System.out.println("Interdit:(liberté=0) la case est prise ou alors le coup est inutile .");  // VERIFIER REGLE ET AJUSTER (confond mort et pris...)
            }
        } else {
            System.out.println("Erreur: la case est déjà occupé.");
        }
    }

    // méthode de calcul de degré de liberté d'une pierre.A vérifier ATTENTION elle est utiliser dans poserPierre
    // Commentaire de Quentin P: cette méthode est à reprendre, elle ne donne pas d'info utile pour la méthode poser pierre. Il faut
    // en sortie que l'on puisse si la pierre est entourée par des pierres blanches et/ou noires pour gérer le suicide d'une
    // seule pierre. En effet le degré de liberté peut être nul mais si on est blanc et que l'on est entouré par
    // des pierres blanches jouer à cet endroit est possible ! 
    public int degreLib(int x, int y) {
        int compt = 0;   //compte les libertes

        if ((x + 1) < taille) {
            if (plateau[x + 1][y].getEtat() == -1) {
                compt++;
            }
        }

        if ((y + 1) < taille) {
            if (plateau[x][y + 1].getEtat() == -1) {
                compt++;
            }
        }

        if ((x - 1) >= 0) {
            if (plateau[x - 1][y].getEtat() == -1) {
                compt++;
            }
        }

        if ((y - 1) >= 0) {
            if (plateau[x][y - 1].getEtat() == -1) {
                compt++;
            }
        }
        return compt;
    }
/**
 * 
 * @param g groupe dont on souhaite calculer le nombre de libertés.
 * @return le nombre de libertés du groupe
 * la méthode se base sur la création d'une matrice d'entier 19*19 initialement nulle.
 * On parcourt les cases voisines des pierres du groupe, si une case est vide
 * on inscrit 1 dans la matrice et on incrémente un compteur. Si il y a déjà un 1 dans la matrice
 * on examine la case ou la pierre suivante.
 *
 */
    public int calculLiberte(Groupe g) {
        int[][] gobanVirtuel = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                gobanVirtuel[i][j] = 0;
            }
        }
        int lib = 0;
        for (int i = 0; i < g.getListePierres().size(); i++) {
            int a = g.getListePierres().get(i).getX();
            int b = g.getListePierres().get(i).getY();
            if ((0 <= a + 1) && (a+1 <= this.taille)) {
                if (plateau[a + 1][b].getCouleur().equalsIgnoreCase("O")) {
                    if (gobanVirtuel[a + 1][b] == 0) {
                        gobanVirtuel[a + 1][b] = 1;
                        lib = lib + 1;
                    }
                }
            }
            if ((0 <= a - 1) && (a-1 <= this.taille)) {
                if (plateau[a - 1][b].getCouleur().equalsIgnoreCase("O")) {
                    if (gobanVirtuel[a - 1][b] == 0) {
                        gobanVirtuel[a - 1][b] = 1;
                        lib = lib + 1;
                    }
                }
            }

            if ((0 <= b + 1) && (b+1<= this.taille)) {
                if (plateau[a][b + 1].getCouleur().equalsIgnoreCase("O")) {
                    if (gobanVirtuel[a][b + 1] == 0) {
                        gobanVirtuel[a][b + 1] = 1;
                        lib = lib + 1;
                    }
                }
            }

            if ((0 <= b - 1) && (b-1<= this.taille)) {
                if (plateau[a][b - 1].getCouleur().equalsIgnoreCase("O")) {
                    if (gobanVirtuel[a][b - 1] == 0) {
                        gobanVirtuel[a][b - 1] = 1;
                        lib = lib + 1;
                    }
                }
            }
        }
        g.setLiberte(lib);
        return lib;

    }
//méthode case vide qui renvoit vrai si la case est vide et faux sinon, 
//on suppose les paramètres justes

    public boolean estVide(int x, int y) {
        boolean test = true;

        if (plateau[x][y].getEtat() == 1 || plateau[x][y].getEtat() == 2 || plateau[x][y].getEtat() == 0) {
            test = false;
        }
        return test;
    }
//méthode no suicide renvoit 0 si la position demandée fait le suicide d'un groupe
//la méthode renvoit vrai si pas de suicide faux sinon

    public boolean nonSuicide(int x, int y, String coul) {
        boolean test = true;
        //On stocke l'actuelle liste de groupe
        ArrayList<Groupe> ancienneListe = new ArrayList<>();
        ancienneListe.equals(listeGroupes);
        //On met à jour les groupes avec la nouvelle position
        mettreAJourGroupe(x, y, coul);
        //si la pierre ajoutée provoque un suicide du nouveau groupe associé alors on recopie l'ancienne liste
        //sinon on supprime la pierre de 
        if (listeGroupes.get(listeGroupes.size() - 1).getEtat() == 0) {
            test = false;
        }
        listeGroupes.equals(ancienneListe);
        return test;
    }
//mettre à jour groupe méthode qui prend en argument deux entiers et une couleur et qui regarde si 
//la pierre appartient à un ancien groupe, fait la jointure de 2 groupes, ou forme un groupe seul (les paramètres sont considérés comme juste)

    public void mettreAJourGroupe(int x, int y, String coul) {
        //récupération de la pierre associée
        Pierre nouvPierre = plateau[x][y];
        //initialisation du groupe associé à la pierre
        Groupe nouvGroupe = new Groupe(maxNumGroupe() + 1, nouvPierre);
        nouvPierre.setNumGroupe(nouvGroupe.getNumGroupe());
        //ajouter le groupe à la liste
        listeGroupes.add(nouvGroupe);
        //il faut regarder les groupes aux alentours
        // on regarde s'il y a un groupe à gauche de la même couleur, si oui on fusionne et on supprime l'ancien
        if ((!estVide(x - 1, y)) && (nouvGroupe.getCouleur().equals(plateau[x - 1][y].getCouleur()))) {
            int numeroPierreAdjacente = indiceGroupe(plateau[x - 1][y].getNumGroupe());
            nouvGroupe.fusion(listeGroupes.get(numeroPierreAdjacente));
            listeGroupes.remove(numeroPierreAdjacente);
        }
        //de même on regarde s'il y a un groupe au dessus de la même couleur, si oui on fusionne et on supprime l'ancien
        if ((!estVide(x, y + 1)) && (nouvGroupe.getCouleur().equals(plateau[x][y + 1].getCouleur()))) {
            int numeroPierreAdjacente = indiceGroupe(plateau[x][y + 1].getNumGroupe());
            nouvGroupe.fusion(listeGroupes.get(numeroPierreAdjacente));
            listeGroupes.remove(numeroPierreAdjacente);
        }
        //de même on regarde s'il y a un groupe à droite de la même couleur, si oui on fusionne et on supprime l'ancien
        if ((!estVide(x + 1, y)) && (nouvGroupe.getCouleur().equals(plateau[x + 1][y].getCouleur()))) {
            int numeroPierreAdjacente = indiceGroupe(plateau[x + 1][y].getNumGroupe());
            nouvGroupe.fusion(listeGroupes.get(numeroPierreAdjacente));
            listeGroupes.remove(numeroPierreAdjacente);
        }
        //de même on regarde s'il y a un groupe au dessus de la même couleur, si oui on fusionne et on supprime l'ancien
        if ((!estVide(x, y - 1)) && (nouvGroupe.getCouleur().equals(plateau[x][y - 1].getCouleur()))) {
            //récupération de l'indice dans le tableau de la pierre adjacente
            int numeroPierreAdjacente = indiceGroupe(plateau[x][y - 1].getNumGroupe());
            //fusion des groupes nouvGroupe et le groupe de la pierre adjacente
            nouvGroupe.fusion(listeGroupes.get(numeroPierreAdjacente));
            //on supprime le groupe initatialment adjacent
            listeGroupes.remove(numeroPierreAdjacente);
        }

    }

    //méthode qui met à jour le deg de la pierre si on l'ajoute à l'emplacement x,y
    public int mettreAJourDeg(Pierre nouvPierre, int x, int y) {
        //par défaut égal à 4
        int degLiberte = 4;
        //diminuer le degré de liberté si occupation des cases
        if ((!estVide(x - 1, y)) || ((x - 1) < 0)) {
            degLiberte--;
        }
        if ((!estVide(x, y + 1)) || ((y + 1) >= taille)) {
            degLiberte--;
        }
        if ((!estVide(x + 1, y)) || ((x + 1) >= taille)) {
            degLiberte--;
        }
        if ((!estVide(x, y - 1)) || ((y - 1) < 0)) {
            degLiberte--;
        }
        return degLiberte;
    }

    //vérification de la validité des champs d'entrée : x et y entre 0 et taille-1 et coul = B ou N
    public boolean estValide(int x, int y, String coul) {
        boolean test = true;
        //condition de validité sur x,y et la couleur
        if ((x < 0) || (x >= taille) || (y < 0) || (y >= taille) || (!(coul.equals("B") || coul.equals("N"))) || (!nonSuicide(x, y, coul))) {
            test = false;
        }
        return test;
    }

    public int maxNumGroupe() {
        int max = 0;
        for (int i = 0; i < listeGroupes.size(); i++) {
            if (listeGroupes.get(i).getNumGroupe() > max) {
                max = listeGroupes.get(i).getNumGroupe();
            }
        }
        return max;
    }

    public int indiceGroupe(int numero) {
        int indice = 0;
        for (int i = 0; i < listeGroupes.size(); i++) {
            if (listeGroupes.get(i).getNumGroupe() == numero) {
                indice = i;
            }
        }
        return indice;
    }

    //getters
    public Pierre[][] getPlateau() {
        return plateau;
    }

    public ArrayList<Groupe> getListeGroupes() {
        return listeGroupes;
    }

    public int getTaille() {
        return taille;
    }

    public int getPierreMorteB() {
        return pierreMorteB;
    }

    public int getPierreMorteN() {
        return pierreMorteN;
    }

    //setters
    public void setPlateau(Pierre[][] plateau) {
        this.plateau = plateau;
    }

    public void setListeGroupes(ArrayList<Groupe> listeGroupes) {
        this.listeGroupes = listeGroupes;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void setPierreMorteB(int pierreMorteB) {
        this.pierreMorteB = pierreMorteB;
    }

    public void setPierreMorteN(int pierreMorteN) {
        this.pierreMorteN = pierreMorteN;
    }
    

}
