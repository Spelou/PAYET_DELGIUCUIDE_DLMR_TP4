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
        Pierre pierreVide = new Pierre("O", -1, 0, -1, -1, -1);
        //initialisation du terrain, on met des pierres vides partout
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                plateau[i][j] = pierreVide;
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

        //affichage du numéro de ligne puis des pierre vivnates contenues dans la matrice
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
        //ajout de la pierre si case non vide, si champs valide et si pas de suicide
        if ((estVide(x, y)) && (estValide(x, y, coul))/* && (nonSuicide(x, y, coul))*/) {
            //création d'une pierre
            Pierre nouvPierre = new Pierre(coul, 1, 4, maxNumGroupe() + 1, x, y);
            mettreAJourDeg(nouvPierre, x, y);
            plateau[x][y] = nouvPierre;
            mettreAJourGroupe(x, y, coul);
        } else //les arguments de base sont faux
        {
            System.out.println("error, bad arguments in method poserPierre");
        }

    }

  public int calculLiberte(Groupe g) {
        int[][] gobanVirtuel = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                gobanVirtuel[i][j]=0;
            }  
        }
        int lib = 0;
        for (int i = 0; i < g.getListePierres().size(); i++) {
            int a = g.getListePierres().get(i).getX();
            int b = g.getListePierres().get(i).getY();
            if (plateau[a + 1][b].getCouleur().equalsIgnoreCase("O")) {
                if (gobanVirtuel[a+1][b] == 0) {
                    gobanVirtuel[a+1][b] = 1;
                    lib = lib + 1;
                }
            }
            if (plateau[a - 1][b].getCouleur().equalsIgnoreCase("O")) {
                if (gobanVirtuel[a-1][b] == 0) {
                    gobanVirtuel[a-1][b] = 1;
                    lib = lib + 1;
                }
            }
            if (plateau[a][b + 1].getCouleur().equalsIgnoreCase("O")) {
                if (gobanVirtuel[a][b+1] == 0) {
                    gobanVirtuel[a][b+1] = 1;
                    lib = lib + 1;
                }
            }
            if (plateau[a][b - 1].getCouleur().equalsIgnoreCase("O")) {
                if (gobanVirtuel[a][b-1] == 0) {
                    gobanVirtuel[a][b-1] = 1;
                    lib = lib + 1;
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
        if (estValide(x, y, "B")) {
            if (plateau[x][y].getEtat() == 1) {
                test = false;
            }
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
