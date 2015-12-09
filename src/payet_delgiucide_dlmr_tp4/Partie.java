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
        gob=new Goban();
        
       
        
        
    }
    
    /**
     * La partie, les joueurs jouent à tour de rôle.
     */
    private void CestPartie(){
        System.out.println("Et que la partie commence, honneur à "+J1.getNom());
        boolean fin=false; // pour savoir si la partie et fini
        while(fin){    //1 while par tour. la partie est finit si fin passe à true
            System.out.println("Où voulez vous mettre votre pierre");
            
        }
    }
    
    
    
}
