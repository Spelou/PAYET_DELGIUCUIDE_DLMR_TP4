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
    
    /**
     * La partie, les joueurs jouent à tour de rôle.
     */
    public void NouvellePartie(){
         System.out.println("Et que la partie commence, honneur à "+J1.getNom()+" :");
        Scanner scan2 = new Scanner(System.in); //pour lire les coordonnées x et y
        int x=0;
        int y=0;
        boolean fin=true; // pour savoir si la partie et fini
        boolean test=true; // pour vérifier que x et y sont dans le goban
        
        while(fin){    //1 while par tour. la partie est finit si fin passe à true
            gob.afficher();
            
//----tour NOIR
            System.out.println("Où voulez vous mettre votre pierre (rentrer x puis y) :\n(-1 -1 si vous passez votre tour)\nx= ");
            //prend et vérifie les coordonnées de xxxxxxxxxx  
            while(test){
                test=false; //on pourra sortir
                x=scan2.nextInt();
            if (!((x>=-1)&&(x<taille))) {
                test=true;  //on recommence
                System.out.println("Erreur: valeur de x hors goban (x>=-1 et x<"+taille+"). Recommencez\nx= ");
            }   
            }
            
              //prend et vérifie les coordonnées de yyyyyyyyyyyyyyyy puis pose ou pas la pierre
            test=true; //remettre à vrai pour rentrer dans la prochaine boucle
            while(test){
                test=false; //on pourra sortir
                System.out.println("y= ");
            y=scan2.nextInt();
            if (!((y>=-1)&&(y<taille))) {
                test=true;  //on recommence
                System.out.println("Erreur: valeur de y hors goban (y>=-1 et y<"+taille+"). Recommencez");
            }   
            }
           test=true; //remettre à vrai pour rentrer dans la prochaine boucle
           
            if(x==-1&&y==-1){  // on regarde si le joueur passe son tour
                System.out.println("Vous passez votre tour.");
                fin=false;   // le premier passe son tour. Si le scond passe son tour "fin" n'est pas changer et permet de sortir de la boucle du jeu.
                             // sinon si le second joueur ne passe pas son tour, on met "fin" à vrai pour continuer le jeu.
            }
            else{                
            gob.poserPierre(x, y,"N"); // On pose la Pierre. ATTENTION faut encore faire les vérifications dans go...
            }
            
//----tour Blanc 
            System.out.println("Au tour des blancs et "+J2.getNom()+" \n Où voulez vous mettre votre pierre (rentrer x puis y):\n(-1 -1 si vous passez votre tour)\nx= ");
            //prend et vérifie les coordonnées de xxxxxxxxxxxxxxxx  BLANC
            while(test){
                test=false; //on pourra sortir
                x=scan2.nextInt();
            if (!((x>=-1)&&(x<taille))) {
                test=true;  //on recommence
                System.out.println("Erreur: valeur de x hors goban(x>=-1 et x<"+taille+"). Recommencer");
            }   
            }
            
              //prend et vérifie les coordonnées de yyyyyyyyyyyy   BLANC
            test=true; //remettre à vrai pour rentrer dans la prochaine boucle
            while(test){
                test=false; //on pourra sortir
                System.out.println("y= ");
            y=scan2.nextInt();
            if (!((y>=-1)&&(y<taille))) {
                test=true;  //on recommence
                System.out.println("Erreur: valeur de y hors goban (y>=-1 et y<"+taille+"). Recommencer");
            }   
            }
            
            if(x==-1&&y==-1){  // on regarde si le joueur passe son tour
            System.out.println("Vous passez votre tour.");
            }
            else{
               gob.poserPierre(x, y, "B"); // On pose la Pierre. ATTENTION faut encore faire les vérifications dans go... 
               fin=true;
                System.out.println("Au tour des noir et "+J1.getNom());
            } 
            test=true; // pour pouvoir rentrer dans les prochaines boucle de test (on aurait pu le mettre au début du 1er while aussi)
        }
        gob.afficher();
        System.out.println("Vous avez arrêté la partie, libre à vous de comptez les points.\n En espérant que vous vous êtes amusé, merci d'avoir choisi notre jeu.");
    }
}
