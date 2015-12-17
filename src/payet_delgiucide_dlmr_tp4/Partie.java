/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import java.util.Scanner;

/**
 *
 * @author Romain
 */
public class Partie {

    //attributs
    private Joueur J1;
    private Joueur J2;
    private Goban gob;
    private int taille;

    /**
     * Constructeur créer les 2 joueur initialise le goban appelé gob...
     */
    public Partie() {
        //création des joueurs
        String nom;
        String couleur = "N";
        Scanner scan = new Scanner(System.in);
        System.out.println("Donner le nom du joueur 1 qui commencera (avec les noirs): ");
        nom = scan.next();
        J1 = new Joueur(nom, couleur);
        couleur = "B"; // la couleur passe au blanc B pour la création de l'autre joueur.
        System.out.println("Donner le nom du joueur 2 (avec les blancs): ");
        nom = scan.next();
        J2 = new Joueur(nom, couleur);

        //création du terrain
        //boucle de vérification
        boolean test = true;//variable de vérification
        //scanner de récupération
        Scanner myScan = new Scanner(System.in);

        while (test) {
            System.out.println("Entrer la taille du goban (9,16,19):"); // on demande les données à l'utilisateur
            int choix = myScan.nextInt();
            this.taille = choix;
            if ((choix == 9) || (choix == 16) || (choix == 19)) {
                test = false; // sortie de boucle
                gob = new Goban(taille);
            } else {
                System.out.println("Vous n'avez pas donné une taille correcte.");
            }
        }
    }

    public Partie(Joueur j1, Joueur j2, Goban gob, int taille) {
        this.J1 = j1;
        this.J2 = j2;
        this.gob = gob;
        this.taille = taille;
    }

    /**
     * La partie, les joueurs jouent à tour de rôle.
     */
    public void NouvellePartie() {
        System.out.println("Et que la partie commence, honneur à " + J1.getNom() + " :");
        Scanner scan2 = new Scanner(System.in); //pour lire les coordonnées x et y
        int x = 0;
        int y = 0;
        boolean fin = true; // pour savoir si la partie et fini

        while (fin) {    //1 while par tour. la partie est finit si fin passe à true
            gob.afficher();
            System.out.println("Au tour des noirs et " + J1.getNom());
//----tour NOIR
            // vérifier que les données entrées par l'utilisateur sont bonnes 
            boolean test = true; // pour vérifier que x et y sont des choix corrects (pas de suicide, pas de ko, bien dans le goban)
            while (test) {
                System.out.println("Où voulez vous mettre votre pierre (rentrez x puis y) :\n(-1 -1 si vous passez votre tour)");
                System.out.println("x =");
                test = false; //on pourra sortir
                x = scan2.nextInt();
                System.out.println("y =");
                y = scan2.nextInt();
                //si les coordonnées ne sont pas valides 
                if (!gob.estValideCoord(x, y)) {
                    test = true;  //on recommence
                    System.out.println("Erreur: valeur de x hors goban (x>=-1 et x<" + taille + "). Recommencez\nx= ");
                } else { //les coordonnées sont valides 
                    if ((x == -1) && (y == -1)) {//le joueur rentre -1,-1 pour passer son tour
                        System.out.println("Le joueur passe son tour");
                        fin = false;
                    } else {//les coordonnées sont différentes de -1,-1 et valides
                        //s'il y a une situation de KO
                        if (!gob.nonKO(x, y, "N")) {
                            test = true; // on recommence
                            System.out.println("Situation de KO, recommencez");
                        } else { //il n'y a pas de KO
                            //il n'y a pas de suicide
                            if (gob.nonSuicide(x, y, "N")) {
                                //on pose la Pierre
                                gob.poserPierre(x, y, "N");
                                gob.mettreAJourNouvGroupe(x, y, "N");
                                gob.mettreAJourGroupe("N");
                                gob.afficher();
                            } else {//on regarde si on est pas en présence d'un oeil
                                //si ce n'est pas un oeil
                                if (gob.nonOeil(x, y, "N")) {
                                    test = true; //on recommence
                                    System.out.println("Impossible de poser la pierre ici, suicide, recommencez");
                                } else {//si c'est un oeil on place la pierre
                                    test = true;
                                    gob.poserPierre(x, y, "N");
                                    gob.mettreAJourNouvGroupe(x, y, "N");
                                    gob.mettreAJourGroupe("N");
                                    gob.afficher();
                                }

                            }
                        }

                    }
                }
            }

//----tour BLANC
            // vérifier que les données entrées par l'utilisateur sont bonnes 
            test = true; // pour vérifier que x et y sont des choix corrects (pas de suicide, pas de ko, bien dans le goban)
            while (test) {
                System.out.println("Où voulez vous mettre votre pierre (rentrer x puis y) :\n(-1 -1 si vous passez votre tour)");
                System.out.println("x =");
                test = false; //on pourra sortir
                x = scan2.nextInt();
                System.out.println("y =");
                y = scan2.nextInt();
                //si les coordonnées ne sont pas valides 
                if (!gob.estValideCoord(x, y)) {
                    test = true;  //on recommence
                    System.out.println("Erreur: valeur de x hors goban (x>=-1 et x<" + taille + "). Recommencez\nx= ");
                } else { //les coordonnées sont valides 
                    if ((x == -1) && (y == -1)) {//le joueur rentre -1,-1 pour passer son tour
                        System.out.println("Le joueur passe son tour");
                        fin = false;
                    } else {//les coordonnées sont différentes de -1,-1 et valides
                        //s'il y a une situation de KO
                        if (!gob.nonKO(x, y, "N")) {
                            test = true; // on recommence
                            System.out.println("Situation de KO, recommencez");
                        } else { //il n'y a pas de KO
                            //il n'y a pas de suicide
                            if (gob.nonSuicide(x, y, "N")) {
                                //on pose la Pierre
                                gob.poserPierre(x, y, "N");
                                gob.mettreAJourNouvGroupe(x, y, "N");
                                gob.mettreAJourGroupe("N");
                                gob.afficher();
                            } else {//on regarde si on est pas en présence d'un oeil
                                //si ce n'est pas un oeil
                                if (gob.nonOeil(x, y, "N")) {
                                    test = true; //on recommence
                                    System.out.println("Impossible de poser la pierre ici, suicide, recommencez");
                                } else {//si c'est un oeil on place la pierre
                                    test = true;
                                    gob.poserPierre(x, y, "N");
                                    gob.mettreAJourNouvGroupe(x, y, "N");
                                    gob.mettreAJourGroupe("N");
                                    gob.afficher();
                                }

                            }
                        }

                    }
                }
            }
            gob.afficher();
            System.out.println("Vous avez arrêté la partie, libre à vous de comptez les points.\n En espérant que vous vous êtes amusé, merci d'avoir choisi notre jeu.");
        }

    }
}
