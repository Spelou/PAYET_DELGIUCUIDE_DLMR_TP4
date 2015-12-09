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
    private int liberte; // nombre de degré de liberté de 0 à 3
    private int numGroupe;
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
    
    
}
