/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import java.util.Scanner;

/**
 *
 * @author Quentin
 */
public class PAYET_DELGIUCIDE_DLMR_TP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bienvenue dans le jeu de go, création du Goban");
        //boucle de vérification
        boolean test = true;//variable de vérification
        //scanner de récupération
        Scanner myScan = new Scanner(System.in);
        int taille = 0;
        while (test) {
            System.out.println("Entrer la taille du goban (9,16,19)"); // on demande les données à l'utilisateur
            int choix = myScan.nextInt();
            taille = choix;
            if ((choix == 9) || (choix == 16) || (choix == 19)) {
                test = false; // sortie de boucle
            } else {
                System.out.println("Vous n'avez pas donné une taille correcte.");
            }
        }
        Goban gob = new Goban(taille);
        gob.afficher();
        /*gob.poserPierre(0, 0, "N");
        gob.afficher();
        gob.poserPierre(0, 0, "B");
        gob.afficher();
        gob.poserPierre(0, 1, "N");
        gob.poserPierre(1, 0, "N");
        gob.poserPierre(0, 0, "B");
        gob.afficher();*/
    }

}
