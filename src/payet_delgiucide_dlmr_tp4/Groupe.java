/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import java.util.LinkedList;

/**
 *
 * @author Romain
 */
public class Groupe {
    //attributs
    private int numGroupe;
    private int liberte; //commence à 0, somme des liberté de chaque pierre du groupe
    private int etat; // ??j'sais plus
    private String couleur; //idem que pour celle de pierre (N ou B)
    private int nombrePierre; 
    private LinkedList<Pierre> listePierres;

    public Groupe(int numGroupe, int liberte, int etat, String couleur, int nombrePierre, LinkedList<Pierre> listePierres) {
        this.numGroupe = numGroupe;
        this.liberte = liberte;
        this.etat = etat;
        this.couleur = couleur;
        this.nombrePierre = nombrePierre;
        this.listePierres = listePierres;
    }
    
    public void ajouterPierre(Pierre pie){
        
    }
    public void fusion(Groupe g){
        
    }
    public void calculLiberte(){
        
    }
    public void changerEtat(){
        
    }
//getteurs
    public int getNumGroupe() {
        return numGroupe;
    }

    public int getLiberte() {
        return liberte;
    }

    public int getEtat() {
        return etat;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getNombrePierre() {
        return nombrePierre;
    }

    public LinkedList<Pierre> getListePierres() {
        return listePierres;
    }
    
//setteurs sans celui de couleur (car à priori une pierre ne change pas de couleur) et sans celui du tableau (inutile)
    public void setNumGroupe(int numGroupe) {
        this.numGroupe = numGroupe;
    }

    public void setLiberte(int liberte) {
        this.liberte = liberte;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setNombrePierre(int nombrePierre) {
        this.nombrePierre = nombrePierre;
    }

}
