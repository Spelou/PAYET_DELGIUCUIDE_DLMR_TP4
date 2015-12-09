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
    private ArrayList listeGroupes;
    private int taille;
    private int pierreMorteB;
    private int pierreMorteN;

// constructeur de Goban - demande la taille avec vérification à l'utilisateur,
//initialise taille, intialise toutes les pierres à vide, initialise les pierres mortes à 0
    public Goban() {
        System.out.println("Bienvenue dans le jeu de go, création du Goban");
        //boucle de vérification
        boolean test = true;//variable de vérification
        //scanner de récupération
        Scanner myScan = new Scanner(System.in);
        while (test) {
            System.out.println("Entrer la taille du goban (9,16,19)"); // on demande les données à l'utilisateur
            int choix = myScan.nextInt();
            this.taille = choix;
            if ((choix == 9) || (choix == 16) || (choix == 19)) {
                test = false; // sortie de boucle
                //initialisation plateau
                plateau = new Pierre[choix][choix];
            } else {
                System.out.println("Vous n'avez pas donné une taille correcte.");
            }
        }
        //création d'une pierre vide
        Pierre pierreVide = new Pierre("O", -1, 0, -1);
        //initialisation du terrain, on met des pierres vides partout
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                plateau[i][j] = pierreVide;
            }
        }
        //initialisation des pierres mortes
        pierreMorteB = 0;
        pierreMorteN = 0;
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
                if ((plateau[j][k].getEtat() == 1) || (plateau[j][k].getEtat() == -1)) {
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
        //ajout de la pierre
        if ((estVide(x, y)) && ((coul.equals("B") || coul.equals("N")))) {
            Pierre nouvPierre = new Pierre(coul, 1, 4, -1);
            plateau[x][y] = nouvPierre;
        } else //les arguments de base sont faux
        {
            System.out.println("error, bad arguments in method poserPierre");
        }

    }
//méthode case vide qui renvoit vrai si la case est vide et faux sinon, 
//on suppose les paramètres justes 

    public boolean estVide(int x, int y) {
        boolean test = true;
        if (plateau[x][y].getEtat() == 1) {
            test = false;
        }
        return test;
    }
//méthode no suicide renvoit 0 si la position demandée fait le suicide d'un groupe
//la méthode renvoit vrai si pas de suicide faux sinon

    public boolean nonSuicide(int x, int y) {
        boolean test = true;

        return test;
    }
//mettre à jour groupe méthode qui prend en argument deux entiers et une couleur et qui regarde si 
//la pierre appartient à un ancien groupe, fait la jointure de 2 groupes, ou forme un groupe seul (les paramètres sont considérés comme juste)

    public void mettreAJourGroupe(int x, int y, String coul) {
        //pierre d'intialisation
        Pierre nouvPierre = new Pierre(coul, 1, -1, 0);
        //initialisation du groupe associé à la pierre
        Groupe nouvGroupe = new Groupe(listeGroupes.size(), nouvPierre);
        //il faut regarder les groupes aux alentours
        if((!estVide(x-1,y-1))&&(nouvGroupe.getCouleur().equals(coul))){
            nouvGroupe.fusion((Groupe)listeGroupes.get(plateau[x-1][y-1].getNumGroupe()));
        }
        else{
            
        }
    }

}
