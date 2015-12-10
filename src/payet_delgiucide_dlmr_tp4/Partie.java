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
/**
 * Constructeur
 * créer les 2 joueur
 * initialise le goban appelé gob...
 */
    public Partie() {
        //création des joueurs
        String nom;
        String couleur="N";
        Scanner scan=new Scanner(System.in);
        System.out.println("Donner le nom du joueur 1 qui commencera (avec les noirs): ");
        nom = scan.next();
        J1=new Joueur(nom,couleur);
        couleur="B"; // la couleur passe au blanc B pour la création de l'autre joueur.
        System.out.println("Donner le nom du joueur 2 (avec les blancs): ");
        nom = scan.next();
        J2=new Joueur(nom,couleur);
        
        //création du terrain
        gob=new Goban(19);
        
       
        
        
    }
    
    /**
     * La partie, les joueurs jouent à tour de rôle.
     */
    private void CestPartie(){
        System.out.println("Et que la partie commence, honneur à "+J1.getNom()+" :");
        boolean fin=false; // pour savoir si la partie et fini
        Scanner scan = new Scanner(System.in);
        int x=0;
        int y=0;
        while(fin){    //1 while par tour. la partie est finit si fin passe à true
            System.out.println("Où voulez vous mettre votre pierre (rentrer x puis y) :\n(-1 -1 si vous passer votre tour)");
            x=scan.nextInt();
            y=scan.nextInt();
            if(x==-1&&y==-1){  // on regarde si le joueur passe son tour
                System.out.println("Vous passez votre tour.");
                fin=true;
            }
            else{
            gob.poserPierre(x, y, "N"); // On pose la Pierre. ATTENTION faut encore faire les vérifications dans go...
            }
            System.out.println("Au tour des blancs et "+J2.getNom()+" \n Où voulez vous mettre votre pierre (rentrer x puis y):\n(-1 -1 si vous passer votre tour)");
            x=scan.nextInt();
            y=scan.nextInt();
            if(x==-1&&y==-1){  // on regarde si le joueur passe son tour
            System.out.println("Vous passez votre tour.");
            }
            else{
               gob.poserPierre(x, y, "N"); // On pose la Pierre. ATTENTION faut encore faire les vérifications dans go... 
               fin=false;
            }        
        }
        System.out.println("Vous avez arrêté la partie, libre à vous de comptez les points.\n En espérant que vous vous êtes amusé, merci d'avoir choisi notre jeu.");
    }
}