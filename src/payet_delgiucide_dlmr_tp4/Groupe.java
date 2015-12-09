/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payet_delgiucide_dlmr_tp4;

import java.util.ArrayList;

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
    private ArrayList<Pierre> listePierres;

    public Groupe(int numGroupe, int liberte, String couleur, Pierre premierePierre) {
        this.numGroupe = numGroupe;
        this.liberte = liberte;
        this.etat = 1;
        this.couleur = couleur;
        nombrePierre = 1;

        listePierres = new ArrayList<Pierre>();
        listePierres.add(premierePierre);
    }

    public void ajouterPierre(Pierre pie) {
        listePierres.add(pie);
    }

    public void fusion(Groupe g) {
        if (g.couleur.equals(this.couleur)) {
            
            liberte+=g.liberte;  // rajout des libertés du groupe à rattacher 
            liberte-=1;  // On n'oublie pas à enlever le degré de liberté qui permet de les relier.
            
            for (int i = 0; i < g.listePierres.size(); i++) { //On change le numéro de groupe de chaque pierre du groupe qui va être supprimé.
                g.listePierres.get(i).setNumGroupe(this.numGroupe);
            }
            listePierres.addAll(g.listePierres); // fusion des listes de pierres des 2 groupe

            g = null;  //suppression du groupe en paramétre. Le garbage collector s'occupe du reste (Vive Java)
            
        } else {
            System.out.println("Erreur: impossible de fusionner 2 groupes de couleurs différentes.");
        }
    }

    public void calculLiberte() {
        for (int i = 0; i < listePierres.size(); i++) {
            liberte += listePierres.get(i).getLiberte();
        }
    }

    public void changerEtat() {

    }

    public void afficherliste() {
        for (int i = 0; i < listePierres.size(); i++) {
            System.out.println(listePierres.get(i).getCouleur().toString());
        }

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

    public ArrayList<Pierre> getListePierres() {
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