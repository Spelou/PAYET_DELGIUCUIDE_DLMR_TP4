/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Quentin
 */
public class Goban {

    //attributs
    private Pierre[][] plateau; //plateau de jeu, matrice de pierre
    private LinkedList listeGroupes;
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
                System.out.println("Vous n'avez pas donner une taille correcte.");
            }
        }
        //création d'une pierre vide
        Pierre pierreVide = new Pierre("vide", 1, 0, -1);
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
        // affichage de la première ligne tel que 0 1 .. 18
        System.out.print("   ");
        for (int i = 0; i < taille; i++) {
            System.out.print(i + "");
        }
        System.out.println("");

        //affichage des 
        for (int j = 0; j < taille; j++) {
            System.out.print(j + " ");
            for (int k = 0; k < taille; k++) {
                if (plateau[j][k].getEtat()==1) {
                    System.out.print(plateau[j][k].getCouleur() + " ");
                }
                else
                {
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }

    }

}
