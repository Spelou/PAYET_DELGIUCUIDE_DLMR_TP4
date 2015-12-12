/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

/**
 *
 * @author Romain
 */
public class Pierre {
    //attributs
    private String couleur; // N,B,V pour Noir, Blanc, Vide
    private int etat;  // 0 mort, 1 prise, 2 en jeu
    private int liberte; // nombre de degré de liberté de 0 à 4
    private int numGroupe;
    private int x; 
    private int y;

    
//getteurs
    
    public Pierre(String color,int state,int liberty,int groupNumber){
        this.couleur=color;
        this.etat=state;
        this.liberte=liberty;
        this.numGroupe=groupNumber;
    }
    
    
    
    /**
     *
     * @return
     */
        public String getCouleur() {
        return couleur;
    }

    /**
     *
     * @return
     */
    public int getEtat() {
        return etat;
    }

    /**
     *
     * @return
     */
    public int getLiberte() {
        return liberte;
    }

    /**
     *
     * @return
     */
    public int getNumGroupe() {
        return numGroupe;
    }
    
//setteurs sans celui de couleur car à priori une pierre ne change pas de couleur

    /**
     *
     * @param etat
     */
        public void setEtat(int etat) {
        this.etat = etat;
    }

    /**
     *
     * @param liberte
     */
    public void setLiberte(int liberte) {
        this.liberte = liberte;
    }

    /**
     *
     * @param numGroupe
     */
    public void setNumGroupe(int numGroupe) {
        this.numGroupe = numGroupe;
    }
 
    //méthode
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
