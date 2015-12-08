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
    private int pierreMorteB;
    private int pierreMorteN;
    

    public Goban() {
        System.out.println("Bienvenue dans le jeu de go, création du Goban");
        //boucle de vérification
        boolean test = true;//variable de vérification
        //scanner de récupération
        Scanner myScan = new Scanner(System.in);
        while (test) {
            System.out.println("Entrer la taille du goban (9,16,19)"); // on demande les données à l'utilisateur
            int choix = myScan.nextInt();
            if ((choix == 9) || (choix == 16) || (choix == 19)) {
                test = false; // sortie de boucle
                //initialisation plateau
                plateau = new Pierre[choix][choix];
            }
            else{
                System.out.println("Vous n'avez pas donner une taille correcte.");
            }
        }
    }

}
